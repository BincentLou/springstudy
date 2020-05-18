package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.configuration.UserConfigurationDemo;
import com.david.study.spring.domain.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    private User user;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionReader beanDefinitionReader =new XmlBeanDefinitionReader(annotationConfigApplicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-xml-injection.xml");
        annotationConfigApplicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);
        annotationConfigApplicationContext.refresh();
        AnnotationDependencyInjectionResolutionDemo annotationDependecyInjecttionDemo = annotationConfigApplicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
        System.out.println(annotationDependecyInjecttionDemo.user);

        annotationConfigApplicationContext.close();
    }


}

