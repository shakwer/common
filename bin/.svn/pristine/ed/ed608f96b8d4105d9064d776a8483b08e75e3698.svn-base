/**
 * File：XmlUtils.java
 * Package：com.fang.common.utils
 * Author：jin
 * Date：2017年4月1日 下午2:08:40
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package com.fang.common.utils;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * <p>
 * Description: XmlUtils
 * </p>
 *
 * @author jinshilei
 *         2017年4月1日
 * @version 1.0
 *
 */
public class XmlReaderUtils {

  /**
   *
   * 通过节点名称获取节点的值
   *
   * @param xmlString
   *        xml字符串文档
   * @param nodeName
   *        节点名称
   * @return 返回值
   */
  public static String readByNodeName(String xmlString, String nodeName) {
    if (StringUtils.isEmpty(xmlString)) {
      return null;
    }
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
      return doc.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
