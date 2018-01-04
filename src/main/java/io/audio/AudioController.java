package io.audio;

import io.file.FileStatDTO;

/**
 * Interface for different audio mixers.
 */
public interface AudioController
{
  /**
   * Tests whether a given file is supported by the controller.
   * @return true when file is supported; false otherwise.
   */
  boolean isSupportedType(FileStatDTO file);

  /**
   * Puts an audiofile in the queue to be played.
   * The queue works as a fifo queue (first-in first-out) adding new files to the tail.
   */
  void queue(FileStatDTO file);

  /**
   * Plays a audiofile from the queue.
   * Removes an audiofile from the head and plays it.
   */
  void play();

  /**
   * Interrupts all ongoing playback.
   */
  void stop();

  /**
   * Sets the volume between [0.0000;1.0000].
   * E.g. 25% volume corresponds to 0.25
   */
  void setVolume(double volumePercent);

  /**
   * Returns the actual volume of the media playback (not your sound driver).
   * @return percentage of the volume between [0.0000;1.0000].
   */
  double getVolume();
}
