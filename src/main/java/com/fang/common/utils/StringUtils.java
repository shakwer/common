/**
 * File：StringUtils.java
 * Package：com.fang.common.utils
 * Author：jin
 * Date：2017年4月1日 上午9:13:13
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Description: StringUtils
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class StringUtils {

  /**
   *
   * 判断字符串是否为空
   *
   * @param string
   *        字符串
   * @return 返回值
   */
  public static boolean isEmpty(String string) {
    if (string == null || string.length() == 0) {
      return true;
    }
    return false;
  }

  /**
   * 判断字符串是否是数字（只判断是否为整数）
   *
   * @param string
   *        判断的字符串
   * @return true 表示是数字，false 表示不是数字
   */
  public static boolean isNumeric(String string) {
    if (!isEmpty(string)) {
      Pattern pattern = Pattern.compile("[0-9]*");
      Matcher isNum = pattern.matcher(string);
      if (isNum.matches()) {
        return true;
      }
    }
    return false;
  }
}
