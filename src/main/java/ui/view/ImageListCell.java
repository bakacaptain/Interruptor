package ui.view;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import ui.model.AudioFile;

/**
 * Custom render for cells in a {@code ListView}.
 */
public class ImageListCell extends ListCell<AudioFile>
{
  private ImageView imageView = new ImageView();

  @Override
  public void updateItem(AudioFile item, boolean empty) {
    super.updateItem(item, empty);

    if (item != null) {
      // TODO: 04-01-2018 insert image
      imageView.setImage(null);
      
      setGraphic(imageView);
      setText(item.getName());
    } else {
      setText(null);
      setGraphic(null);
    }
  }
}
