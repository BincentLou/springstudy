package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.UserHolder;
import com.david.study.spring.dependency.annotation.MyAutowiredExt;
import com.david.study.spring.dependency.configuration.UserConfigurationDemo;
import com.david.study.spring.dependency.date.CityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import com.david.study.spring.domain.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AnnotationDependencyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

//        BeanDefinitionReader beanDefinitionReader =new  XmlBeanDefinitionReader(annotationConfigApplicationContext);
//        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-xml-injection.xml");
//
        annotationConfigApplicationContext.register(UserConfigurationDemo.class);

        annotationConfigApplicationContext.refresh();

//        UserHolder userHolder = annotationConfigApplicationContext.getBean(UserHolder.class);
//        System.out.println(userHolder);
        AnnotationDependencyInjectionDemo annotationDependecyInjecttionDemo = annotationConfigApplicationContext.getBean(AnnotationDependencyInjectionDemo.class);
        System.out.println(annotationDependecyInjecttionDemo.allSuperUser);
        System.out.println(annotationDependecyInjecttionDemo.user);
        System.out.println(annotationDependecyInjecttionDemo.user2);
        System.out.println(annotationDependecyInjecttionDemo.user1);
        System.out.println(annotationDependecyInjecttionDemo.user3);
        System.out.println(annotationDependecyInjecttionDemo.myAutowiredExt);

        annotationConfigApplicationContext.close();
    }


//    @Bean
//    public UserHolder userHolder(User user, CityEnum cityEnum){
//        return new UserHolder(user,cityEnum);
//    }

    @Autowired
    private Collection<User> allSuperUser;

    @Autowired
    @Qualifier //按照Qualifier 区分
    private  User user;

    @Autowired
    @Qualifier("user2") //按照名称查找
    private  User user2;

    @Resource(name = "user")  //Resource 不能注释static
    private  User user1;

    @Resource  //Resource 不能注释static 按照名称查找
    private  User user3;

    @MyAutowiredExt
    @Qualifier("user2")
    private User myAutowiredExt;

}

