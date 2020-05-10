package com.david.study.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.david.study.spring.domain.User;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 8:18 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeanInitiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/instantiontial-bean-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User staticCreateUser = beanFactory.getBean("static-create-user",User.class);
        User factoryCreateUser = beanFactory.getBean("factory-ceate-user",User.class);
        User springFactoryBeanUser = beanFactory.getBean("spring-factory-bean-create",User.class);

        System.out.println(user);
        System.out.println(staticCreateUser);
        System.out.println(factoryCreateUser);
        System.out.println(springFactoryBeanUser);
    }
}
