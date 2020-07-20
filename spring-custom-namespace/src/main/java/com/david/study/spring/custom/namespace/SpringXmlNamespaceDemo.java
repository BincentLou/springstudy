package com.david.study.spring.custom.namespace;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/7/15 5:02 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SpringXmlNamespaceDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("/META-INF/beans.xml");

        Map<String, Custom> map = defaultListableBeanFactory.getBeansOfType(Custom.class);

        map.entrySet().forEach(entry->{
            System.out.printf("name: %s \n",entry.getKey());
            System.out.printf("value: %s \n",entry.getValue());
        });
    }
}
