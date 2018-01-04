package ui.controller;

import execution.SceneRouter;
import io.audio.impl.FXAudioController;
import io.file.FileStatDTO;
import io.file.FileUtil;
import io.file.impl.FileUtilImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import ui.model.AudioFile;
import ui.util.FileConverter;
import ui.view.ImageListCell;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LibraryController
{
  private SceneRouter router;
  private ObservableList<AudioFile> data = FXCollections.observableArrayList();
  private FXAudioController player = new FXAudioController();

  @FXML
  private ListView<AudioFile> listView;

  @FXML
  private void initialize() {
    listView.setCellFactory(e -> new ImageListCell());
    listView.setOnMouseClicked(this::playOnDoubleClick);
    listView.setItems(data);
  }

  public void setSceneRouter(SceneRouter router) {
    this.router = Objects.requireNonNull(router);
  }

  @FXML
  public void handleOnReload() {
    data.clear();

    FileUtil util = new FileUtilImpl();
    Collection<FileStatDTO> files = util.discoverDir("main/resources");

    List<AudioFile> audioFiles = files.stream()
      .map(FileConverter::toAudioFile)
      .collect(Collectors.toList());

    data.addAll(audioFiles);
  }

  @FXML
  public void handleOnStopPlaying() {
    player.stop();
  }

  @FXML
  public void handleOnGotoSetting() {
    router.gotoSettings();
  }

  private void playOnDoubleClick(MouseEvent event) {
    if (event.getClickCount() == 2
      && event.getButton() == MouseButton.PRIMARY) {

      AudioFile audioFile = listView.getSelectionModel().getSelectedItem();

      if (audioFile != null) {
        playSelected(audioFile);
      }
    }
  }

  private void playSelected(AudioFile file) {
    if (file == null) {
      return;
    }

    player.queue(FileConverter.toFileStatDTO(file));
    player.stop();
    player.play();
  }
}
