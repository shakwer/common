/**
 * File：PropertiesUtils.java
 * Package：com.fang.common.utils
 * Author：jin
 * Date：2017年4月1日 上午9:18:00
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.utils;

import java.util.ResourceBundle;

/**
 * <p>
 * Description: 属性文件读取
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class PropertiesUtils {

  /**
   * 动态的bundle
   */
  private static ResourceBundle dynamicBundle;

  /**
   * 读取fangcommon配置文件的专用Bundle
   */
  private static ResourceBundle bundleForFangCommon;

  /**
   * 静态代码块
   */
  static {
    bundleForFangCommon = ResourceBundle.getBundle("fangcommon_constants");
  }

  /**
   *
   * 只读取fang.common的fangcommon_constants.properties文件
   *
   * @param key
   *        key名
   * @return 返回值
   */
  public static String getFangCommonValue(String key) {
    return bundleForFangCommon.getString(key);
  }

  /**
   *
   * 读取classpath下的属性文件
   *
   * @param path
   *        属性文件路径
   * @param key
   *        key名
   * @return 返回值
   */
  public static String getValue(String path, String key) {
    dynamicBundle = ResourceBundle.getBundle(path);
    return dynamicBundle.getString(key);
  }
}
