package com.david.study.spring.dependency.configuration;

import com.david.study.spring.dependency.injection.AnnotationDependencyInjectionDemo;
import com.david.study.spring.dependency.injection.LazyAnnotationDependencyInjectionDemo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.david.study.spring.domain.User;

/**
 * @version $Id: null.java, v 1.0 2020/5/17 9:14 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
public class UserConfigurationDemo {

    @Bean
    public User user2(){
        User user =  new User();
        user.setName("User2");
        return user;
    }
    @Bean
    public User user(){
        User user =  new User();
        user.setName("User");
        return user;
    }

    @Bean
    @Qualifier
    public User user3(){
        User user =  new User();
        user.setName("User3");
        return user;
    }

    @Bean
    public AnnotationDependencyInjectionDemo annotationDependencyInjectionDemo(){
        return new AnnotationDependencyInjectionDemo();
    }

    @Bean
    public LazyAnnotationDependencyInjectionDemo lazyAnnotationDependencyInjectionDemo(){
        return new LazyAnnotationDependencyInjectionDemo();
    }
}
