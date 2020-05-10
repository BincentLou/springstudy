package com.david.study.spring.bean;

import com.david.study.spring.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 4:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //1：通过BeanDefinitionBuilder构建
        BeanDefinition beanDefinition =BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("name","DavidHaha")
                .addPropertyValue("age",22)
                .getBeanDefinition();
        System.out.println(beanDefinition);

        //2;通过AbstractBeanDefinition及派生类获取BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name","DavidHa")
                      .add("age",23);
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
