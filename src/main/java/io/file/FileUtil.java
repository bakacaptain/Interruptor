package io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

public interface FileUtil
{
  Collection<FileStatDTO> discoverDir(String dir);

  FileInputStream readFileAsStream(String filepath) throws FileNotFoundException;
}
