package com.david.study.spring.metadata;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @version $Id: null.java, v 1.0 2020/7/13 9:49 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SelfBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return SelfBean.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        super.doParse(element, builder);
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        setPropertiesValues("id",builder,element);
        setPropertiesValues("name",builder,element);
        setPropertiesValues("city",builder,element);
    }

    private void setPropertiesValues(String propertyName, BeanDefinitionBuilder builder, Element element) {
        String attributeValue = element.getAttribute(propertyName);
        builder.addPropertyValue(propertyName,attributeValue);
    }
}
