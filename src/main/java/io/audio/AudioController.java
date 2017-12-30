package io.audio;

import io.file.FileStatDTO;

public interface AudioController
{
  boolean isSupportedType(FileStatDTO file);

  void queue(FileStatDTO file);

  void play();

  void stop();

  void setVolume(double volumePercent);

  double getVolume();
}
