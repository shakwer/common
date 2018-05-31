/**
 * File：RsaEncryptUtils.java
 * Package：com.fang.common.security
 * Author：jin
 * Date：2017年10月19日 下午7:53:39
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.security;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import com.fang.common.data.DataConvertUtils;

/**
 * <p>
 * Description: RsaEncryptUtils
 * </p>
 *
 * @author jinshilei
 *         2017年10月19日
 * @version 1.0
 *
 */
public final class RsaEncryptUtils {

  /**
   *
   * 私有化构造函数
   */
  private RsaEncryptUtils() {

  }

  /**
   *
   * 将字符串进行非对称加密。
   *
   * @param input
   *        要加密的字符串
   * @param modulusHex
   *        模数16进制字符串
   * @param publicExponentHex
   *        公钥16进制字符串
   * @return 返回加密后字符串
   * @throws Exception
   *         异常
   */
  public static String encrypt(String input, String modulusHex, String publicExponentHex)
      throws Exception {
    PublicKey pubKey = getRsaPublicKey(modulusHex, publicExponentHex);
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE, pubKey);
    byte[] cipherData = cipher.doFinal(input.getBytes("UTF-8"));
    // 将加密结果(byte数组)转换为16进制字符串
    return DataConvertUtils.bytesToHexing(cipherData);
  }

  /**
   *
   * 解密非对称加密的字符串
   *
   * @param input
   *        要解密的字符串
   * @param modulusHex
   *        模数16进制字符串
   * @param privateExponentHex
   *        私钥16进制字符串
   * @return 返回解密后的明文
   * @throws Exception
   *         异常
   */
  public static String decrypt(String input, String modulusHex, String privateExponentHex)
      throws Exception {
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    PrivateKey privateKey = getRsaPrivateKey(modulusHex, privateExponentHex);
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    // 加密字符串为16进制字符串，解析为byte数组，进行解密
    byte[] resultBytes = cipher.doFinal(DataConvertUtils.hexToBytes(input));
    return new String(resultBytes, "UTF-8");
  }

  /**
   *
   * rsa使用私钥对字符串进行签名
   *
   * @param input
   *        要签名的字符串
   * @param modulusHex
   *        素数乘积(模数)16进制字符串
   * @param privateExponentHex
   *        私钥16进制字符串
   * @param signAlgorithm
   *        签名算法
   * @return 返回
   * @throws Exception
   *         异常
   */
  public static String signature(String input, String modulusHex, String privateExponentHex,
                                 String signAlgorithm) throws Exception {
    PrivateKey privateKey = getRsaPrivateKey(modulusHex, privateExponentHex);
    Signature signature = Signature.getInstance(signAlgorithm);
    signature.initSign(privateKey);
    signature.update(input.getBytes("UTF-8"));
    byte[] resBytes = signature.sign();
    return DataConvertUtils.bytesToHexing(resBytes);
  }

  /**
   *
   * rsa使用公钥对签名进行验证
   *
   * @param sign
   *        签名字符串
   * @param content
   *        签名前的字符串
   * @param modulusHex
   *        素数乘积(模数)16进制字符串
   * @param publicExponentHex
   *        公钥16进制字符串
   * @param signAlgorithm
   *        签名算法
   * @return 返回
   * @throws Exception
   *         异常
   */
  public static boolean verifySignature(String sign, String content, String modulusHex,
                                        String publicExponentHex, String signAlgorithm)
      throws Exception {
    PublicKey publicKey = getRsaPublicKey(modulusHex, publicExponentHex);
    Signature signature = Signature.getInstance(signAlgorithm);
    signature.initVerify(publicKey);
    signature.update(content.getBytes("UTF-8"));
    return signature.verify(DataConvertUtils.hexToBytes(sign));
  }

  /**
   *
   * 通过素数乘积和公钥生成公钥对象
   *
   * @param modulusHex
   *        素数乘积(模数)16进制字符串
   * @param publicExponentHex
   *        公钥16进制字符串
   * @return 返回
   * @throws Exception
   *         异常
   */
  private static PublicKey getRsaPublicKey(String modulusHex, String publicExponentHex)
      throws Exception {
    // 解析大素数乘积
    byte[] modulusBytes = DataConvertUtils.hexToBytes(modulusHex);
    // 解析公钥
    byte[] publicExponentBytes = DataConvertUtils.hexToBytes(publicExponentHex);
    BigInteger modulusInteger = new BigInteger(1, modulusBytes);
    BigInteger publicExponentInteger = new BigInteger(1, publicExponentBytes);
    RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulusInteger, publicExponentInteger);
    KeyFactory fact = KeyFactory.getInstance("RSA");
    PublicKey pubKey = fact.generatePublic(rsaPubKey);
    return pubKey;
  }

  /**
   *
   * getRsaPrivateKey
   *
   * @param modulusHex
   *        素数乘积(模数)16进制字符串
   * @param privateExponentHex
   *        私钥16进制字符串
   * @return 返回
   * @throws Exception
   *         异常
   */
  private static PrivateKey getRsaPrivateKey(String modulusHex, String privateExponentHex)
      throws Exception {
    // 解析大素数乘积
    byte[] modulusBytes = DataConvertUtils.hexToBytes(modulusHex);
    // 解析私钥
    byte[] privateExponentBytes = DataConvertUtils.hexToBytes(privateExponentHex);
    BigInteger modulusInteger = new BigInteger(1, modulusBytes);
    BigInteger privateExponentInteger = new BigInteger(1, privateExponentBytes);
    RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(modulusInteger, privateExponentInteger);
    KeyFactory fact = KeyFactory.getInstance("RSA");
    RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(privateKeySpec);
    return privateKey;
  }
}
