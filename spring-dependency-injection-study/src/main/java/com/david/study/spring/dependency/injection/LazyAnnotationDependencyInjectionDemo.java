package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.UserHolder;
import com.david.study.spring.dependency.configuration.UserConfigurationDemo;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private Collection<User> user;

    @Autowired //推荐 objectProvider 实现延迟注入，继承ObjectFactory;
    private ObjectProvider<User> userObjectProvider;

    @Autowired // ObjectProvider 容易出现null控制指针
    private ObjectFactory<Collection<User>> userFactory;


    @Autowired
    private ObjectProvider<UserHolder> userHolderObjectProvider;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(UserConfigurationDemo.class);
        annotationConfigApplicationContext.refresh();

        LazyAnnotationDependencyInjectionDemo demo = annotationConfigApplicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

        System.out.println(demo.user);
        demo.userObjectProvider.forEach(System.out::println);
        System.out.println(demo.userFactory.getObject());
        System.out.println(demo.userHolderObjectProvider.getIfAvailable());
        annotationConfigApplicationContext.close();
    }


}

