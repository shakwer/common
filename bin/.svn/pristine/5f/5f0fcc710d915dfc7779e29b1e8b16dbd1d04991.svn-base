/**
 * File：DesEncrypt.java
 * Package：com.fang.common.security
 * Author：jin
 * Date：2017年4月1日 上午10:36:20
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * <p>
 * Description: DesEncrypt
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public final class DesEncryptUtils {

  /**
   * 将构造函数私有，禁止该类实例化
   */
  private DesEncryptUtils() {

  }

  /**
   *
   * DES加密(默认UTF-8编码)
   *
   * @param text
   *        待加密字符串
   * @param key
   *        加密的key(只能是8位)
   * @return 返回值
   * @throws Exception
   *         异常
   */
  public static String encrypt(String text, String key) throws Exception {
    return encrypt(text, key, "UTF-8");
  }

  /**
   *
   * DES解密(默认UTF-8编码)
   *
   * @param text
   *        待解密字符串
   * @param key
   *        解密的key(只能是8位)
   * @return 返回值
   * @throws Exception
   *         异常
   */
  public static String decrypt(String text, String key) throws Exception {
    return decrypt(text, key, "UTF-8");
  }

  /**
   *
   * DES加密
   *
   * @param text
   *        待加密字符串
   * @param key
   *        加密的key(只能是8位)
   * @param charset
   *        编码
   * @return 返回值
   * @throws Exception
   *         异常
   */
  public static String encrypt(String text, String key, String charset) throws Exception {
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charset));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes(charset));
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
    byte[] bytes = cipher.doFinal(text.getBytes(charset));
    return new String(Base64.encodeBase64(bytes));
  }

  /**
   *
   * DES解密
   *
   * @param text
   *        待解密字符串
   * @param key
   *        解密的key(只能是8位)
   * @param charset
   *        编码
   * @return 返回值
   * @throws Exception
   *         异常
   */
  public static String decrypt(String text, String key, String charset) throws Exception {
    byte[] bytes = Base64.decodeBase64(text.getBytes());
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charset));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes(charset));
    cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
    byte[] bytesResult = cipher.doFinal(bytes);
    return new String(bytesResult, charset);
  }
}
