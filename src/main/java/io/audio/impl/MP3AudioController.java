package io.audio.impl;

import io.audio.AudioController;
import io.file.FileStatDTO;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class MP3AudioController implements AudioController
{
  private Queue<MediaPlayer> mediaQueue;

  public MP3AudioController() {
    mediaQueue = new ArrayDeque<>();
  }

  @Override
  public boolean isSupportedType(FileStatDTO file) {
    return false;
  }

  @Override
  public void queue(FileStatDTO file) {
    // TODO: 28-12-2017 supported guard
    Media media = new Media(new File(file.getPath()).toURI().toString());
    mediaQueue.offer(new MediaPlayer(media));
  }

  @Override
  public void play() {
    if (mediaQueue.isEmpty()) {
      return;
    }

    MediaPlayer player = mediaQueue.remove();
    player.play();
  }

  @Override
  public void stop() {

  }

  @Override
  public void setVolume(double volumePercent) {

  }

  @Override
  public double getVolume() {
    return 0;
  }
}
