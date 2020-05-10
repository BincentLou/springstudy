package com.david.study.spring.dependency.lookup;

import com.david.study.spring.annotation.Super;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 11:10 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DependencyLookUp {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
//        lookUpByName(beanFactory);
//        lookUpLazyByName(beanFactory);
//        lookUpByType(beanFactory);
//        lookUpCoolectionByType(beanFactory);
        lookUpByAnnotation(beanFactory);

    }

    private static void lookUpByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User> users =  (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(users);
        }
    }

    private static void lookUpLazyByName(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

    private static void lookUpCoolectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users =  listBeanFactory.getBeansOfType(User.class);
            for(User user:users.values()){
                System.out.println(user);
            }
        }
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static void lookUpByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
