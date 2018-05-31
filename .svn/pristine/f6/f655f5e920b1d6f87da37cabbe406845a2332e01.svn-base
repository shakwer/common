/**
 * File：FileUtils.java
 * Package：com.fang.common.io
 * Author：jin
 * Date：2017年10月25日 下午5:52:11
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * <p>
 * Description: FileUtils
 * </p>
 *
 * @author jinshilei
 *         2017年10月25日
 * @version 1.0
 *
 */
public abstract class IOUtils {

  /**
   *
   * 私有化构造函数
   */
  private IOUtils() {
  }

  /**
   *
   * 读取小文件
   *
   * @param fileClassPath
   *        文件的classpath路径
   * @return 返回文件内容
   */
  public static String readClassPathFileAsString(String fileClassPath) {
    File file = getClassPathFile(fileClassPath);
    return readByFile(file);
  }

  /**
   * 获取classpath下文件的File对象
   *
   * @param fileClassPath
   *        文件的classpath路径
   * @return 返回File对象
   */
  public static File getClassPathFile(String fileClassPath) {
    String path = null;
    if (fileClassPath.startsWith("classpath:")) {
      path = fileClassPath.substring("classpath:".length());
    } else {
      path = fileClassPath;
    }
    ClassLoader classLoader = getClassLoader();
    URL url = (classLoader != null) ? classLoader.getResource(path) : ClassLoader
        .getSystemResource(path);

    try {
      URI uri = new URI(url.toString());
      File file = new File(uri.getSchemeSpecificPart());
      return file;
    } catch (Exception e) {
    }
    return new File(path);
  }

  /**
   *
   * 读取文件
   *
   * @param file
   *        文件对象
   * @return 返回文件内容
   */
  public static String readByFile(File file) {
    BufferedReader bufferedReader = null;
    try {
      FileReader fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      String line = bufferedReader.readLine();
      StringBuilder builder = null;
      if (line != null) {
        builder = new StringBuilder();
        builder.append(line);
        builder.append(System.getProperty("line.separator"));
        while ((line = bufferedReader.readLine()) != null) {
          builder.append(line);
          builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
        }
      }
    }
    return null;
  }

  /**
   * 获取类加载器
   *
   * @return 返回类加载器
   */
  private static ClassLoader getClassLoader() {
    ClassLoader loader = null;
    try {
      loader = Thread.currentThread().getContextClassLoader();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (loader == null) {
      loader = IOUtils.class.getClassLoader();
      if (loader == null) {
        loader = ClassLoader.getSystemClassLoader();
      }
    }
    return loader;
  }
}
