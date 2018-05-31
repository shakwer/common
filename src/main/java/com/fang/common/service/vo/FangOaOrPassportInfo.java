/**
 * File：FangOaOrPassportInfo.java
 * Package：com.fang.common.service.vo
 * Author：jin
 * Date：2017年4月18日 上午11:25:46
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.service.vo;

/**
 * <p>
 * Description: FangOaOrPassportInfo
 * </p>
 *
 * @author jinshilei
 *         2017年4月18日
 * @version 1.0
 *
 */
public class FangOaOrPassportInfo {

  /**
   * OA的id
   */
  private String oaid;

  /**
   * OA邮箱
   */
  private String loginid;

  /**
   * OA的uuid
   */
  private String uuid;

  /**
   * 通行证用户id
   */
  private String fangid;

  /**
   * 通行证用户名
   */
  private String fangname;

  /**
   *
   * getOaid
   *
   * @return 返回值
   */
  public String getOaid() {
    return oaid;
  }

  /**
   *
   * setOaid
   *
   * @param oaid
   *        OA的id
   */
  public void setOaid(String oaid) {
    this.oaid = oaid;
  }

  /**
   *
   * getLoginid
   *
   * @return 返回值
   */
  public String getLoginid() {
    return loginid;
  }

  /**
   *
   * setLoginid
   *
   * @param loginid
   *        OA邮箱
   */
  public void setLoginid(String loginid) {
    this.loginid = loginid;
  }

  /**
   *
   * getUuid
   *
   * @return 返回值
   */
  public String getUuid() {
    return uuid;
  }

  /**
   *
   * setUuid
   *
   * @param uuid
   *        OA的uuid
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   *
   * getFangid
   *
   * @return 返回值
   */
  public String getFangid() {
    return fangid;
  }

  /**
   *
   * setFangid
   *
   * @param fangid
   *        通行证用户id
   */
  public void setFangid(String fangid) {
    this.fangid = fangid;
  }

  /**
   *
   * getFangname
   *
   * @return 返回值
   */
  public String getFangname() {
    return fangname;
  }

  /**
   *
   * setFangname
   *
   * @param fangname
   *        通行证用户名
   */
  public void setFangname(String fangname) {
    this.fangname = fangname;
  }
}
