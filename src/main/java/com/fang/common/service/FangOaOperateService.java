/**
 * File：FangOaAuthentication.java
 * Package：com.fang.common.service
 * Author：jin
 * Date：2017年4月1日 上午8:52:39
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.service;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fang.common.network.HttpClientUtils;
import com.fang.common.security.DesEncryptUtils;
import com.fang.common.service.vo.FangOaAuthenResult;
import com.fang.common.service.vo.FangOaOrPassportInfo;
import com.fang.common.service.vo.FangOaOrPassportInfoQueryInVo;
import com.fang.common.service.vo.FangOaOrPassportInfoResult;
import com.fang.common.utils.CookieUtils;
import com.fang.common.utils.GuidUtils;
import com.fang.common.utils.OutParameterUtils;
import com.fang.common.utils.PropertiesUtils;
import com.fang.common.utils.StringUtils;
import com.fang.common.utils.XmlReaderUtils;

/**
 * <p>
 * Description: 房天下OA操作
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class FangOaOperateService {

  /**
   * OA Des加密key
   */
  private static String oaDeskey = PropertiesUtils.getFangCommonValue("oa_des_key");

  /**
   * OA用户操作接口
   */
  private static String oaUserOperateUrl = PropertiesUtils.getFangCommonValue("oauser_operate_url");

  /**
   *
   * 房天下OA认证(判断OA用户是否具有某后台系统权限)
   *
   * @param request
   *        请求
   * @param oaServiceId
   *        后台系统在OA的编号
   * @param responseResult
   *        OA接口返回结果
   * @return 返回值
   */
  public static boolean authenticate(HttpServletRequest request, String oaServiceId,
                                     OutParameterUtils<FangOaAuthenResult> responseResult) {
    FangOaAuthenResult result = null;
    String oaCookieValue = CookieUtils.getCookieValue(request,
        PropertiesUtils.getFangCommonValue("oaauthen_cookie_name"));
    System.out.println("oaCookieValue--"+oaCookieValue);
    if (!StringUtils.isEmpty(oaCookieValue)) {
      String oaAuthenUrl = PropertiesUtils.getFangCommonValue("oaauthen_url") + "&isso_sid="
          + oaServiceId + "&oa_token=" + oaCookieValue;
      System.out.println("oaAuthenUrl--"+oaAuthenUrl);
      try {
        String resultString = HttpClientUtils.requestUrl(oaAuthenUrl);
        System.out.println("resultString--"+resultString);
        if (!StringUtils.isEmpty(resultString)) {
          result = (FangOaAuthenResult) JSONObject.parseObject(resultString,
              FangOaAuthenResult.class);
          if (responseResult != null) {
            responseResult.setValue(result);
          }
          if (result.getCode().equals("0")) {
            return true;
          }
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return false;
  }

  /**
   *
   * 向oa注册用户对特定后台系统的权限
   *
   * @param request
   *        web请求
   * @param email
   *        用户邮箱
   * @param oaServiceId
   *        特定后台系统在oa的编号
   * @return 返回值
   */
  public static boolean registerToOa(HttpServletRequest request, String email, String oaServiceId) {
    try {
      String sign = URLEncoder
          .encode(DesEncryptUtils.encrypt(String.format("actv_v2_%s_%s", email, oaServiceId), oaDeskey),
              "UTF-8");
      String oaRegisterUrl = oaUserOperateUrl + "?act=actv_v2&oa_username=" + email + "&isso_sid="
          + oaServiceId + "&ip=" + HttpClientUtils.getIp(request) + "&info=" + GuidUtils.getGuid()
          + "&sign=" + sign;
      String result = HttpClientUtils.requestUrl(oaRegisterUrl);
      if (!StringUtils.isEmpty(result)) {
        String resultCode = XmlReaderUtils.readByNodeName(result, "code");
        System.out.println("激活结果码：" + resultCode + "(0:成功，-8：OA中该用户已经有了该后台系统的权限)");
        if (!StringUtils.isEmpty(resultCode) && resultCode.equals("0")) {
          return true;
          // code=-8，OA中该用户已经有了该后台系统的权限
        }
      }
      System.out.println(oaRegisterUrl);
    } catch (Exception e) {
      System.out.println("注册失败");
      e.printStackTrace();
    }
    return false;
  }

  /**
   *
   * 向oa删除用户对特定后台系统的权限
   *
   * @param request
   *        web请求
   * @param email
   *        用户邮箱
   * @param oaServiceId
   *        特定后台系统在oa的编号
   * @return 返回值
   */
  public static boolean deleteUserFromOa(HttpServletRequest request, String email,
                                         String oaServiceId) {
    try {
      String sign = URLEncoder.encode(
          DesEncryptUtils.encrypt(String.format("deactv_v2_%s_%s", email, oaServiceId), oaDeskey),
          "UTF-8");
      String oaRegisterUrl = oaUserOperateUrl + "?act=deactv_v2&oa_username=" + email
          + "&isso_sid=" + oaServiceId + "&ip=" + HttpClientUtils.getIp(request) + "&info="
          + GuidUtils.getGuid() + "&sign=" + sign;
      String result = HttpClientUtils.requestUrl(oaRegisterUrl);
      if (!StringUtils.isEmpty(result)) {
        String resultCode = XmlReaderUtils.readByNodeName(result, "code");
        System.out.println("删除结果码" + resultCode + "(0：成功，-4：无此用户,其他失败)");
        if (!StringUtils.isEmpty(resultCode) && (resultCode.equals("0") || resultCode.equals("-4"))) {
          return true;
          // 0：成功，-4：无此用户
        }
      }
    } catch (Exception e) {
      System.out.println("删除失败");
      e.printStackTrace();
    }
    return false;
  }

  /**
   *
   * OA用户和通行证用户信息互查
   *
   * @param queryValue
   *        oa或通行证用户的id或邮箱
   * @param queryType
   *        loginid/uuid/oaid/fangid 四者选一
   * @param resultType
   *        json或xml
   * @return 返回值
   * @throws Exception
   *         异常
   */
  @SuppressWarnings("deprecation")
  public static FangOaOrPassportInfo getFangOaOrPassportUserInfo(String queryValue,
                                                                 String queryType, String resultType)
      throws Exception {
    String url = PropertiesUtils.getFangCommonValue("oa_getInfo_url");
    FangOaOrPassportInfoQueryInVo inVo = new FangOaOrPassportInfoQueryInVo();
    inVo.setQuerytype(queryType);
    inVo.setQueryvalue(queryValue);
    inVo.setReturndata(resultType);
    String jsonString = JSON.toJSONString(inVo);
    String param = DesEncryptUtils.encrypt(jsonString, PropertiesUtils.getFangCommonValue("oa_des_key"));
    url += "&param=" + URLEncoder.encode(param);
    String result = HttpClientUtils.requestUrl(url, 3000, "GB2312");
    FangOaOrPassportInfoResult infoResult = null;
    if (!StringUtils.isEmpty(result)) {
      infoResult = JSONObject.parseObject(result, FangOaOrPassportInfoResult.class);
    }
    if (infoResult != null && infoResult.getData() != null) {
      FangOaOrPassportInfo info = infoResult.getData()[0];
      if (!StringUtils.isEmpty(info.getFangname())) {
        return info;
      }
    }
    return null;
  }
}
