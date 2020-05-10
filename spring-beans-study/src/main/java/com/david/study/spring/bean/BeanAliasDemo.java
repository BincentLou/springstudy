package com.david.study.spring.bean;

import com.david.study.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 5:53 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-alias-context.xml");
        User davidUser = beanFactory.getBean("David-user", User.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(davidUser == user);
    }
}
