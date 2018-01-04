package ui.controller;

import execution.SceneRouter;
import javafx.fxml.FXML;

import java.util.Objects;

public class SettingController
{
  private SceneRouter router;

  @FXML
  private void initialize() {
  }

  public void setSceneRouter(SceneRouter router) {
    this.router = Objects.requireNonNull(router);
  }

  @FXML
  public void handleOnBackPressed() {
    router.gotoMain();
  }
}
