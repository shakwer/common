/**
 * File：AesEncryptUtils.java
 * Package：com.fang.passport.authentication.common
 * Author：jin
 * Date：2017年10月19日 下午4:19:09
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.fang.common.data.DataConvertUtils;

/**
 * <p>
 * Description: AesEncryptUtils
 * </p>
 *
 * @author jinshilei
 *         2017年10月19日
 * @version 1.0
 *
 */
public final class AesEncryptUtils {

  /**
   *
   * 构造函数私有化，禁止该类的实例化
   */
  private AesEncryptUtils() {
  }

  /**
   *
   * AES加密方法
   *
   * @param key
   *        密钥(16位英文字符串)
   * @param input
   *        要加密的字符串
   * @return 返回加密字符串
   * @throws Exception
   *         异常
   */
  public static String encrypt(String key, String input) throws Exception {
    IvParameterSpec iv = new IvParameterSpec(key.getBytes());
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), iv);
    int blockSize = cipher.getBlockSize();
    byte[] dataBytes = input.getBytes("UTF-8");
    int plaintextLength = dataBytes.length;
    if (plaintextLength % blockSize != 0) {
      plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
    }
    byte[] plaintext = new byte[plaintextLength];
    System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
    byte[] resultBytes = cipher.doFinal(plaintext);
    return new String(DataConvertUtils.bytesToHexing(resultBytes));
  }

  /**
   *
   * AES解密方法
   *
   * @param key
   *        密钥(16位英文字符串)
   * @param input
   *        要解密的字符串
   * @return 返回解密后的明文
   * @throws Exception
   *         异常
   */
  public static String decrypt(String key, String input) throws Exception {
    IvParameterSpec iv = new IvParameterSpec(key.getBytes());
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), iv);
    byte[] resultBytes = cipher.doFinal(DataConvertUtils.hexToBytes(input));
    return new String(resultBytes, "UTF-8").replaceAll("\0", "");
  }
}
