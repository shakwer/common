/**
 * File：FangOaOrPassportInfoResult.java
 * Package：com.fang.common.service.vo
 * Author：jin
 * Date：2017年4月18日 上午11:24:03
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.service.vo;

/**
 * <p>
 * Description: FangOaOrPassportInfoResult
 * </p>
 *
 * @author jinshilei
 *         2017年4月18日
 * @version 1.0
 *
 */
public class FangOaOrPassportInfoResult {

  /**
   * 接口结果描述
   */
  private String message;

  /**
   * 结果编号
   */
  private String result;

  /**
   * 返回的信息
   */
  private FangOaOrPassportInfo[] data;

  /**
   *
   * getMessage
   *
   * @return 返回值
   */
  public String getMessage() {
    return message;
  }

  /**
   *
   * setMessage
   *
   * @param message
   *        接口结果描述
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   *
   * getResult
   *
   * @return 返回值
   */
  public String getResult() {
    return result;
  }

  /**
   *
   * setResult
   *
   * @param result
   *        结果编号
   */
  public void setResult(String result) {
    this.result = result;
  }

  /**
   *
   * getData
   *
   * @return 返回值
   */
  public FangOaOrPassportInfo[] getData() {
    return data;
  }

  /**
   *
   * setData
   *
   * @param data
   *        返回的信息
   */
  public void setData(FangOaOrPassportInfo[] data) {
    this.data = data;
  }

}
