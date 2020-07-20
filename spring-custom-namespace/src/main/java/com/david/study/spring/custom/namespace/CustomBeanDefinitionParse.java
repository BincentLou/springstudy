package com.david.study.spring.custom.namespace;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @version $Id: null.java, v 1.0 2020/7/15 4:43 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:custom 标签的解析器
 * @since 1.0
 **/
public class CustomBeanDefinitionParse extends AbstractSingleBeanDefinitionParser {

    static final String  CUSTOM_ID_ATTRIBUTE = "id";
    static final String  CUSTOM_NAME_ATTRIBUTE = "name";
    static final String  CUSTOM_AGE_ATTRIBUTE = "age";
    static final String  CUSTOM_SEX_ATTRIBUTE = "sex";
    static final String  CUSTOM_CLASS_ATTRIBUTE = "class";

    @Override
    protected String getBeanClassName(Element element) {
        return element.getAttribute(CUSTOM_CLASS_ATTRIBUTE);
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        builder.addPropertyValue(CUSTOM_ID_ATTRIBUTE,element.getAttribute(CUSTOM_ID_ATTRIBUTE));
        builder.addPropertyValue(CUSTOM_AGE_ATTRIBUTE,element.getAttribute(CUSTOM_AGE_ATTRIBUTE));
        builder.addPropertyValue(CUSTOM_NAME_ATTRIBUTE,element.getAttribute(CUSTOM_NAME_ATTRIBUTE));
        builder.addPropertyValue(CUSTOM_SEX_ATTRIBUTE,element.getAttribute(CUSTOM_SEX_ATTRIBUTE));
    }
}
