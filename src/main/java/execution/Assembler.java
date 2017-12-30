package execution;

import io.audio.impl.MP3AudioController;
import io.file.FileStatDTO;
import io.file.FileUtil;
import io.file.impl.FileUtilImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collection;

public class Assembler extends Application
{
  @Override
  public void start(Stage stage) {
    Group root = new Group();
    Scene scene = new Scene(root, 500, 500, Color.BLACK);
    stage.setTitle("The title");
    stage.setScene(scene);
    stage.show();

    FileUtil util = new FileUtilImpl();
    Collection<FileStatDTO> medias = util.discoverDir("resources");

    MP3AudioController controller = new MP3AudioController();
    controller.queue(medias.iterator().next());
    controller.play();
  }

  public static void main(String... args) {
    launch(args);
  }
}
