package com.david.study.spring.lifecycle;

import com.david.study.spring.domain.UserHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/7/1 8:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeanLifeCycleInApplicationContextDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        applicationContext.refresh();
        applicationContext.getBean(UserHolder.class);
        applicationContext.close();
    }
}
