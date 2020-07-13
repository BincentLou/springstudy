package com.david.study.spring.metadata;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/7/13 9:03 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SpringExtensionXmlDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        int a =  xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/self-beans.xml");
        Map<String ,SelfBean> map =  defaultListableBeanFactory.getBeansOfType(SelfBean.class);
        for (Map.Entry<String,SelfBean> entry:map.entrySet()) {
            System.out.printf("name %s , bean %s \n",entry.getKey(),entry.getValue());
        }
        System.out.println(a);
    }
}
