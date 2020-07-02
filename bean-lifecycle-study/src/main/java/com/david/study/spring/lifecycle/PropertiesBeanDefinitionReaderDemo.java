package com.david.study.spring.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import com.david.study.spring.domain.User;

/**
 * @version $Id: null.java, v 1.0 2020/6/19 9:18 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: bean definition 的读取实现，propertiesBeanDefinitionReader
 * @since 1.0
 **/
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(defaultListableBeanFactory);
        String location = "META-INF/beans.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodeResource = new EncodedResource(resource,"UTF-8");
        int beanDefinitionLoaded =  propertiesBeanDefinitionReader.loadBeanDefinitions(encodeResource);
        System.out.printf("已经加载bean %d",beanDefinitionLoaded);
        User user = defaultListableBeanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
