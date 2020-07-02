package com.david.study.spring.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/6/20 11:15 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:spring beanDefinition 的读取实现 AnnotationBeanDefinitionReader的示例
 * @since 1.0
 **/
public class AnnotatedBeanDefinitionReaderDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedBeanDefinitionReaderDemo.class);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath://META-INF/beans.xml");

        AnnotatedBeanDefinitionReader definitionReader = new AnnotatedBeanDefinitionReader(defaultListableBeanFactory);
        int beanDefinitionCountBefore = defaultListableBeanFactory.getBeanDefinitionCount();
        definitionReader.registerBean(AnnotatedBeanDefinitionReaderDemo.class);

        int beanDefinitionCountAfter = defaultListableBeanFactory.getBeanDefinitionCount();
        System.out.println(beanDefinitionCountBefore);
        System.out.println(beanDefinitionCountAfter-beanDefinitionCountBefore);


    }
}
