/**
 * File：TestFor.java
 * Package：com.fang.common
 * Author：jin
 * Date：2017年7月24日 下午3:20:37
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.fang.common.enums.HttpRequestMethod;
import com.fang.common.network.HttpClientUtils;

/**
 * <p>
 * Description: TestFor
 * </p>
 *
 * @author jinshilei
 *         2017年7月24日
 * @version 1.0
 *
 */
public class TestFor {

  /**
   *
   * main
   *
   * @param args
   *        参数
   * @throws Exception
   *         异常
   */
  public static void main(String[] args) throws Exception {
    // requestFangCouponByPost();
    // thirdGetCoupon();
    // String res = HttpClientUtils
    // .requestUrl("http://jk.passport.fang.com/checkcookie.aspx?ip=127.0.0.1");
    // System.out.println(res);
    // System.out.println(System.getProperty("java.class.path"));
    // String res =
    // FileUtils.readClassPathFileAsString("classpath:fangcommon_constants.properties");
  }

  /**
   *
   * requestFangCouponByPost
   *
   * @throws Exception
   *         异常
   */
  private static void requestFangCouponByPost() throws Exception {

    // http://jk.coupon.fang.com/Coupon/Get_All_Coupons_List.api?building_id=1618822843&call_time=2017-08-23+16%3a27%3a40.520&currentpage=1&group_sign_id=40210&pagesize=1&sign=ca8f7c3ecb5bbef329cc73a6d4d187f6

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    // String url = "http://localhost.fang.com:8080/Coupon/Get_All_Coupons_List.api";
    // String url = "http://localhost.fang.com:8080/Coupon/Get_All_Coupons_List.api";
    // String url = "http://jk.coupon.test.fang.com/Coupon/Get_All_Coupons_List.api";
    // String url = "http://jk.coupon.test.fang.com/ThirdCoupons/Get_All_ThirdCoupons_List.api";
    // String url = "http://localhost.fang.com:8080/ThirdCoupons/Get_All_ThirdCoupons_List.api";
    // String url = "http://jk.coupon.fang.com/Coupon/Use_Coupon_Used.api";
    String url = "http://jk.coupon.test.fang.com/ThirdCoupons/Get_All_ThirdCoupons_List.api";
    Date date = new Date();
    // String str = "call_time=" + simpleDateFormat.format(date) + "&cityname=北京"
    // + "&coupon_id=2d0d45ac2e9f4cb59b06e14b5e51ce07" + "&group_sign_id=20000" + "&platform=PC"
    // + "&user_id=52959325";
    // + "&isshowinnewhousedetail=0"
    // String str = "building_id=1010123303" + "&call_time=" + simpleDateFormat.format(date)
    // + "&currentpage=1" + "&group_sign_id=20000" + "&isshowinnewhousedetail=1" + "&pagesize=50";

    String str = "call_time=" + simpleDateFormat.format(date)
        + "&currentpage=1&group_sign_id=10100&pagesize=10";
    String realStr = "call_time=" + simpleDateFormat.format(date)
        + "&currentpage=1&group_sign_id=10100&pagesize=10";
    // String strAndKey = str + "&key=672024d3dcef41cc8c392043a9b74aa9";
    String strAndKey = str + "&key=672024d3dcef41cc8c392043a9b74aa9";
    System.out.println(strAndKey);
    String sign = getMD5(strAndKey, "UTF-8");

    String finalUlr = url + "?" + realStr + "&sign=" + sign;

    HashMap<String, String> postParameter = new HashMap<String, String>();
    postParameter.put("call_time", simpleDateFormat.format(date));
    // postParameter.put("city_name", "哈尔滨");
    postParameter.put("currentpage", "1");
    postParameter.put("pagesize", "10");
    // postParameter.put("CouponID", "9d643d80158640aba676844d4c03cfd4");
    // postParameter.put("isshowinnewhousedetail", "1");
    // postParameter.put("discount_amount", "20.00");
    postParameter.put("group_sign_id", "10100");
    // postParameter.put("order_amount", "20.00");
    // postParameter.put("order_id", "200");
    // postParameter.put("order_time", "2017/11/01 10:11:22");
    // postParameter.put("origin", "201711");
    // postParameter.put("platform", "wap");
    // postParameter.put("Type", "WAP");
    // postParameter.put("returntype", "2");
    // postParameter.put("UserID", "84912149");
    // postParameter.put("uid", "ca50066433254796838367a82f24d89a");
    postParameter.put("sign", sign);
    System.out.println(sign);
    System.out.println(finalUlr);
    String result = HttpClientUtils.requestUrl(url, 1000000, 1000000, "UTF-8",
        HttpRequestMethod.POST, postParameter);
    System.out.println(result);
  }

  /**
   *
   * requestCouponByPost
   *
   * @throws Exception
   *         异常
   */
  private static void thirdGetCoupon() throws Exception {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    String url = "http://jk.coupon.fang.com:8081/ThirdCoupons/User_Get_ThirdCoupon.api";
    // String url = "http://localhost.fang.com:8080/ThirdCoupons/User_Get_ThirdCoupon.api";
    Date date = new Date();
    String str = "call_time=" + simpleDateFormat.format(date) + "&cityname=北京"
        + "&coupon_id=5e29823fea1b43158c398c7ef52a3065" + "&group_sign_id=10100" + "&platform=PC"
        + "&user_id=52959325";
    String realStr = "call_time=" + simpleDateFormat.format(date) + "&cityname=%e5%8c%97%e4%ba%ac"
        + "&coupon_id=5e29823fea1b43158c398c7ef52a3065" + "&group_sign_id=10100" + "&platform=PC"
        + "&user_id=52959325";
    String strAndKey = str + "&key=672024d3dcef41cc8c392043a9b74aa9";
    String sign = getMD5(strAndKey, "UTF-8");

    String finalUlr = url + "?" + realStr + "&sign=" + sign;

    HashMap<String, String> postParameter = new HashMap<String, String>();
    postParameter.put("call_time", simpleDateFormat.format(date));
    postParameter.put("cityname", "北京");
    postParameter.put("coupon_id", "5e29823fea1b43158c398c7ef52a3065");
    postParameter.put("group_sign_id", "10100");
    postParameter.put("platform", "PC");
    postParameter.put("user_id", "52959325");
    postParameter.put("sign", sign);
    System.out.println(sign);
    System.out.println(finalUlr);
    String result = HttpClientUtils.requestUrl(url, 1000000, 1000000, "UTF-8",
        HttpRequestMethod.POST, postParameter);
    System.out.println(result);
  }

  /**
   *
   * getMD5
   *
   * @param input
   *        输入
   * @param charset
   *        编码
   * @return 返回
   * @throws NoSuchAlgorithmException
   *         异常
   */
  public static String getMD5(String input, String charset) throws NoSuchAlgorithmException {
    MessageDigest m = MessageDigest.getInstance("MD5");
    byte[] digest = null;
    try {
      digest = m.digest(input.getBytes(charset));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String hash = new BigInteger(1, digest).toString(16);

    while (hash.length() < 32) {
      hash = "0".concat(hash);
    }
    return hash.toUpperCase();
  }
}
