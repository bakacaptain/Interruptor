package ui.util;

import io.file.FileStatDTO;
import ui.model.AudioFile;

/**
 * Converts between DTOs
 */
public class FileConverter
{
  public static AudioFile toAudioFile(FileStatDTO file) {
    return new AudioFile(file.getName(), file.getPath());
  }

  public static FileStatDTO toFileStatDTO(AudioFile file) {
    return new FileStatDTO(file.getName(), file.getPath());
  }
}
