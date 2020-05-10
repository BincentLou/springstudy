package com.david.study.spring.dependency.injection;

import com.david.study.spring.annotation.Super;
import com.david.study.spring.domain.User;
import com.david.study.spring.domain.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 11:10 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DependencyInjection {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        lookUpByName(beanFactory);


    }


    private static void lookUpByName(BeanFactory beanFactory) {
        UserRepository user = (UserRepository) beanFactory.getBean("userRepository");
//        System.out.println(user);
        BeanFactory isFactory = user.getBeanFactory();
//        System.out.println(isFactory);
//        System.out.println(beanFactory);
//        System.out.println(beanFactory == isFactory);
        ObjectFactory<ApplicationContext> objectFactory = user.getObjectFactory();
        BeanFactory osBeanFactory = beanFactory.getBean(BeanFactory.class);
        System.out.println(osBeanFactory);
//        System.out.println(objectFactory.getObject()==beanFactory);
    }
}
