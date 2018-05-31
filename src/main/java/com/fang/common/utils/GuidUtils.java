/**
 * File：GuidUtils.java
 * Package：com.fang.common.utils
 * Author：jin
 * Date：2017年4月1日 下午1:39:42
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.utils;

import java.util.UUID;

/**
 * <p>
 * Description: GuidUtils
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class GuidUtils {

  /**
   *
   * 获取guid
   *
   * @return 返回值
   */
  public static String getGuid() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
