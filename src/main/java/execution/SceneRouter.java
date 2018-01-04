package execution;

/**
 * Interface used for navigation between views.
 * It routes between scenes hence the name: SceneRouter
 */
public interface SceneRouter
{
  /**
   * Routes to the main scene
   */
  void gotoMain();

  /**
   * Routes to the setting scene
   */
  void gotoSettings();

  /**
   * Routes to the help scene
   */
  void gotoHelp();
}
