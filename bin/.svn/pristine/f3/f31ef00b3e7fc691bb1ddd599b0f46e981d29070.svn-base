/**
 * File：CookieUtils.java
 * Package：com.fang.common.utils
 * Author：jin
 * Date：2017年4月1日 上午9:08:12
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Description: CookieUtils
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class CookieUtils {

  /**
   *
   * getCookieValue
   *
   * @param request
   *        请求
   * @param key
   *        cookie的名
   * @return 返回值
   */
  public static String getCookieValue(HttpServletRequest request, String key) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(key)) {
          return cookies[i].getValue();
        }
      }
    }
    return null;
  }

  /**
   *
   * 向浏览器种cookie(默认域名：.fang.com,默认有效时间：会话级，关闭浏览器失效)
   *
   * @param response
   *        web响应
   * @param key
   *        cookie的key
   * @param value
   *        cookie的值
   */
  public static void writeCookie(HttpServletResponse response, String key, String value) {
    writeCookie(response, key, value, ".fang.com", -1);
  }

  /**
   *
   * 向浏览器种cookie
   *
   * @param response
   *        web响应
   * @param key
   *        cookie的key
   * @param value
   *        cookie的值
   * @param domain
   *        域名
   * @param maxAge
   *        cookie的有效期(秒)
   */
  public static void writeCookie(HttpServletResponse response, String key, String value,
                                 String domain, int maxAge) {
    Cookie cookie = new Cookie(key, value);
    if (maxAge > 0) {
      cookie.setMaxAge(maxAge);
    }
    if (!StringUtils.isEmpty(domain)) {
      cookie.setDomain(domain);
    }
    response.addCookie(cookie);
  }

  /**
   *
   * 删除cookie
   *
   * @param response
   *        web响应
   * @param key
   *        cookie的名
   * @param domain
   *        域名
   */
  public static void deleteCookie(HttpServletResponse response, String key, String domain) {
    Cookie cookie = new Cookie(key, null);
    cookie.setMaxAge(0);
    if (!StringUtils.isEmpty(domain)) {
      cookie.setDomain(domain);
    }
    response.addCookie(cookie);
  }
}
