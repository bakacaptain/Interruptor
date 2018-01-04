package io.file;

import java.util.Objects;

/**
 * A DTO containing metadata for files.
 */
public class FileStatDTO
{

  private String name;
  private String path;

  public FileStatDTO(String name, String path) {
    this.name = name;
    this.path = Objects.requireNonNull(path);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FileStatDTO that = (FileStatDTO) o;
    return Objects.equals(name, that.name) &&
      Objects.equals(path, that.path);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, path);
  }

  @Override
  public String toString() {
    return "FileStatDTO{" +
      "name='" + name + '\'' +
      ", path='" + path + '\'' +
      '}';
  }
}
