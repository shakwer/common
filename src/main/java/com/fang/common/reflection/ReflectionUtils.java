/**
 * File：ReflectionUtils.java
 * Package：com.fang.passport.authentication.common
 * Author：jin
 * Date：2017年10月18日 上午11:38:53
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description: ReflectionUtils
 * </p>
 *
 * @author jinshilei
 *         2017年10月18日
 * @version 1.0
 *
 */
public final class ReflectionUtils {

  /**
   * 将构造函数私有，禁止该类实例化
   */
  private ReflectionUtils() {

  }

  /**
   *
   * 将对象的属性名和属性值组成的key-value对，按照属性名的字典顺序排序后放入有序Map，并返回
   *
   * @param obj
   *        对象
   * @param isIncludeInherit
   *        设置是否包含继承来的字段
   * @return 返回
   * @throws IllegalArgumentException
   *         异常
   * @throws IllegalAccessException
   *         异常
   */
  public static LinkedHashMap<String, Object> getSortFieldValueByFieldName(Object obj,
                                                                           boolean isIncludeInherit)
      throws IllegalArgumentException, IllegalAccessException {
    @SuppressWarnings("rawtypes")
    Class clazz = obj.getClass();
    // getDeclaredFields能访问类中所有的字段,与public,private,protect无关；但是不能访问从其它类继承来的字段
    Field[] declareFields = clazz.getDeclaredFields();
    Map<String, Object> properties = new HashMap<String, Object>();
    LinkedHashMap<String, Object> returnProperties = new LinkedHashMap<String, Object>();
    if (declareFields != null && declareFields.length > 0) {
      for (Field field : declareFields) {
        field.setAccessible(true);
        properties.put(field.getName(), field.get(obj));
      }
    }
    if (isIncludeInherit) {
      // getFields()只能访问类中声明为公有的字段,私有的字段它无法访问；能访问从其它类继承来的公有字段
      Field[] fields = clazz.getFields();
      if (fields != null && fields.length > 0) {
        for (Field field : fields) {
          if (!properties.keySet().contains(field.getName())) {
            properties.put(field.getName(), field.get(obj));
          }
        }
      }
    }
    if (properties.size() > 0) {
      List<String> list = new ArrayList<String>();
      list.addAll(properties.keySet());
      // 将属性名称按照字母的字典顺序排序
      Collections.sort(list);
      // 将按照key排序后的key-value放入有序map并返回
      for (String propertyName : list) {
        returnProperties.put(propertyName, properties.get(propertyName));
      }
    }
    if (returnProperties.size() > 0) {
      return returnProperties;
    }
    return null;
  }
}
