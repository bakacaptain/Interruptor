package io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Common file utilities
 */
public interface FileUtil
{
  /**
   * Return lighweight metadata about the contents of a given directory path.
   * @return metadata of a given directory.
   */
  Collection<FileStatDTO> discoverDir(String dir);

  /**
   * Reads a file as a stream based on a filepath
   * @return Stream of the file being read.
   */
  FileInputStream readFileAsStream(String filepath) throws FileNotFoundException;
}
