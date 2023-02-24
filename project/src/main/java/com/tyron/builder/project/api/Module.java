package com.tyron.builder.project.api;

import com.tyron.builder.model.ModuleSettings;
import com.tyron.builder.project.cache.CacheHolder;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jetbrains.kotlin.com.intellij.openapi.util.UserDataHolderEx;

public interface Module extends UserDataHolderEx, CacheHolder {

  ModuleSettings getSettings();

  FileManager getFileManager();

  File getRootFile();

  File getGradleFile();

  File getSettingsGradleFile();

  File getRootProject();

  String getPlugins();

  List<String> getImplementationProjects();

  List<String> getIncludedProjects();

  default String getName() {
    return getRootFile().getName();
  }

  /**
   * Start parsing the project contents such as manifest data, project settings, etc.
   *
   * <p>Implementations may throw an IOException if something went wrong during parsing
   */
  void open() throws IOException;

  /** Remove all the indexed files */
  void clear();

  void index();

  /**
   * @return The directory that this project can use to compile files
   */
  File getBuildDirectory();

  File getBuildClassesDirectory();
}