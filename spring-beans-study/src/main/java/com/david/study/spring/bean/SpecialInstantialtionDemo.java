package com.david.study.spring.bean;

import com.david.study.spring.factory.DefaultUserFactoryBean;
import com.david.study.spring.factory.UserFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 8:52 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SpecialInstantialtionDemo {
    public static void main(String[] args) {
        //1。 SeviceLoader 实例化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/specail-instantiontial-bean-context.xml");
//        serviceLoader();
        ServiceLoader<UserFactoryBean> serviceLoader = applicationContext.getBean("serviceLoader", ServiceLoader.class);
        System.out.println(serviceLoader.iterator().next().createUser());
        //2。 autowireCapableBeanFactory.createBean
        AutowireCapableBeanFactory beanFactory = applicationContext.getBeanFactory();
        DefaultUserFactoryBean userFactory = beanFactory.createBean(DefaultUserFactoryBean.class);
        System.out.println(userFactory.createUser());
    }

    public static void serviceLoader(){
        ServiceLoader<UserFactoryBean> serviceLoader = ServiceLoader.load(UserFactoryBean.class,Thread.currentThread().getContextClassLoader());
        UserFactoryBean userFactoryBean = serviceLoader.iterator().next();
        System.out.println(userFactoryBean.createUser());
    }
}
