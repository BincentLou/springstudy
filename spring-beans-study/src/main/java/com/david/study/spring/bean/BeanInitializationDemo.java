package com.david.study.spring.bean;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.david.study.spring.domain.User;
import org.springframework.context.annotation.Lazy;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 9:30 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:实例化+初始化+销毁
 * @since 1.0
 **/
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        System.out.println("spring application context refresh");

        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        User userA = new User();
        beanFactory.registerSingleton("userA",userA);

        User userB = (User) beanFactory.getBean("userA");

        System.out.println(userA == userB);

        applicationContext.close();

        Thread.sleep(5000L);
        System.gc();
        Thread.sleep(5000L);

    }

    @Bean(initMethod = "initialUserMethod",destroyMethod = "doDestroy")
    @Lazy
    User user(){
        return new User();
    }
}
