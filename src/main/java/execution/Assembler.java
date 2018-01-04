package execution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.controller.LibraryController;
import ui.controller.SettingController;

import java.io.IOException;

/**
 * Assembles the application for execution.
 * Also seen as a bootstrap or "the main".
 */
public class Assembler extends Application implements SceneRouter
{
  private static final String APP_TITLE = "Interruptor";
  private Stage stage;

  public static void main(String... args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;
    this.stage.setTitle(APP_TITLE);

    gotoMain();
  }

  @Override
  public void gotoMain() {
    try {
      // Load root layout from fxml file.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../ui/view/Library.fxml"));
      Pane layout = loader.load();
      LibraryController controller = loader.getController();
      controller.setSceneRouter(this);

      // Show the scene containing the root layout.
      Scene scene = new Scene(layout);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void gotoSettings() {
    try {
      // Load root layout from fxml file.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../ui/view/Setting.fxml"));
      Pane layout = loader.load();
      SettingController controller = loader.getController();
      controller.setSceneRouter(this);

      // Show the scene containing the root layout.
      Scene scene = new Scene(layout);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void gotoHelp() {

  }
}
