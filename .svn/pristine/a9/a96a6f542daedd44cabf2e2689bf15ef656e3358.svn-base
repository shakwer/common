/**
 * File：DataConvertUtils.java
 * Package：com.fang.passport.authentication.common
 * Author：jin
 * Date：2017年10月19日 下午4:12:36
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.data;

/**
 * <p>
 * Description: DataConvertUtils
 * </p>
 *
 * @author jinshilei
 *         2017年10月19日
 * @version 1.0
 *
 */
public final class DataConvertUtils {

  /**
   * 将构造函数私有，禁止该类实例化
   */
  private DataConvertUtils() {

  }

  /**
   *
   * byte数组转换为16进制字符串
   *
   * @param bytes
   *        byte数组
   * @return 返回16进制字符串
   */
  public static String bytesToHexing(byte[] bytes) {
    StringBuilder builder = new StringBuilder();
    if (bytes != null && bytes.length > 0) {
      for (byte b : bytes) {
        String hex = Integer.toHexString(b & 0xff);
        if (hex.length() < 2) {
          builder.append("0");
          builder.append(hex);
        } else {
          builder.append(hex);
        }
      }
    }
    return builder.toString();
  }

  /**
   *
   * 16进制字符串转换为byte数组
   *
   * @param input
   *        16进制字符串
   * @return 返回byte数组
   */
  public static byte[] hexToBytes(String input) {
    byte[] digest = new byte[input.length() / 2];
    for (int i = 0; i < digest.length; i++) {
      String byteString = input.substring(2 * i, 2 * i + 2);
      int byteValue = Integer.parseInt(byteString, 16);
      digest[i] = (byte) byteValue;
    }
    return digest;
  }
}
