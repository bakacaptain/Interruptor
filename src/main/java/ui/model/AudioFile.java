package ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class AudioFile
{
  private final StringProperty name;
  private final StringProperty path;

  public AudioFile() {
    this(null, null);
  }

  public AudioFile(String name, String path) {
    this.name = new SimpleStringProperty(name);
    this.path = new SimpleStringProperty(path);
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getPath() {
    return path.get();
  }

  public StringProperty pathProperty() {
    return path;
  }

  public void setPath(String path) {
    this.path.set(path);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AudioFile audioFile = (AudioFile) o;
    return Objects.equals(name, audioFile.name) &&
      Objects.equals(path, audioFile.path);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, path);
  }

  @Override
  public String toString() {
    return "AudioFile{" +
      "name=" + name +
      ", path=" + path +
      '}';
  }
}
