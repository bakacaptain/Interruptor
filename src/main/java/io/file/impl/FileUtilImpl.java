package io.file.impl;

import io.file.FileStatDTO;
import io.file.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileUtilImpl implements FileUtil
{
  @Override
  public Collection<FileStatDTO> discoverDir(String dir) {
    File directory = new File(dir);
    File[] filesInDir = directory.listFiles();
    return Arrays.stream(Objects.requireNonNull(filesInDir))
      .filter(Objects::nonNull)
      .map(file -> new FileStatDTO(file.getName(), file.getPath()))
      .collect(Collectors.toList());
  }

  @Override
  public FileInputStream readFileAsStream(String filepath) throws FileNotFoundException {
    return new FileInputStream(filepath);
  }
}
