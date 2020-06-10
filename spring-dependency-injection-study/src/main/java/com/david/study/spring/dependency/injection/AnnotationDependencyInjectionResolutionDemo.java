package com.david.study.spring.dependency.injection;

import com.david.study.spring.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    private User user;

    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @javax.inject.Inject
    private User injetcUser;

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

