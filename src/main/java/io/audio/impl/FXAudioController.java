package io.audio.impl;

import io.audio.AudioController;
import io.file.FileStatDTO;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implementation of the AudioController based on JavaFX's {@link MediaPlayer}.
 * See supported filetypes in the JavaFX API.
 */
public class FXAudioController implements AudioController
{
  private Queue<MediaPlayer> mediaQueue;
  private MediaPlayer player;
  private double volumePercent;

  public FXAudioController() {
    mediaQueue = new ArrayDeque<>();
    volumePercent = 1.0; // default volume is 100%
  }

  @Override
  public boolean isSupportedType(FileStatDTO file) {
    // TODO: 28-12-2017 supported guard
    return true;
  }

  @Override
  public void queue(FileStatDTO file) {
    if (isSupportedType(file)) {
      Media media = new Media(new File(file.getPath()).toURI().toString());
      mediaQueue.offer(new MediaPlayer(media));
    }
  }

  @Override
  public void play() {
    if (mediaQueue.isEmpty()) {
      return;
    }

    player = mediaQueue.remove();
    player.setVolume(volumePercent);
    player.play();
  }

  @Override
  public void stop() {
    if (player != null) {
      player.stop();
    }
  }

  @Override
  public void setVolume(double volumePercent) {
    this.volumePercent = volumePercent;
    if (player != null) {
      player.setVolume(volumePercent);
    }
  }

  @Override
  public double getVolume() {
    return player != null ? player.getVolume() : volumePercent;
  }
}
