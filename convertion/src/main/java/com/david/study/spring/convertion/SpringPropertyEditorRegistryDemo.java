package com.david.study.spring.convertion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/7/31 11:01 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SpringPropertyEditorRegistryDemo {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/convertion-context.xml");

        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        applicationContext.close();
    }
}
