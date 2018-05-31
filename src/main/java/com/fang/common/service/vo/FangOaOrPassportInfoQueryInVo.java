/**
 * File：FangOaOrPassportInfoQueryVo.java
 * Package：com.fang.common.service.vo
 * Author：jin
 * Date：2017年4月18日 上午11:19:39
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.service.vo;

/**
 * <p>
 * Description: FangOaOrPassportInfoQueryVo
 * </p>
 *
 * @author jinshilei
 *         2017年4月18日
 * @version 1.0
 *
 */
public class FangOaOrPassportInfoQueryInVo {

  /**
   * OA邮箱或通行证id
   */
  private String queryvalue;

  /**
   * 查询类型(loginid/uuid/oaid/fangid 四者选一)
   */
  private String querytype;

  /**
   * json或xml
   */
  private String returndata;

  /**
   *
   * getQueryvalue
   *
   * @return 返回值
   */
  public String getQueryvalue() {
    return queryvalue;
  }

  /**
   *
   * setQueryvalue
   *
   * @param queryvalue
   *        OA邮箱或通行证id
   */
  public void setQueryvalue(String queryvalue) {
    this.queryvalue = queryvalue;
  }

  /**
   *
   * getQuerytype
   *
   * @return 返回值
   */
  public String getQuerytype() {
    return querytype;
  }

  /**
   *
   * setQuerytype
   *
   * @param querytype
   *        查询类型(loginid/uuid/oaid/fangid 四者选一)
   */
  public void setQuerytype(String querytype) {
    this.querytype = querytype;
  }

  /**
   *
   * getReturndata
   *
   * @return 返回值
   */
  public String getReturndata() {
    return returndata;
  }

  /**
   *
   * setReturndata
   *
   * @param returndata
   *        json或xml
   */
  public void setReturndata(String returndata) {
    this.returndata = returndata;
  }

}
