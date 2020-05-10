package com.david.study.spring.dependency.ioccontainer;

import com.david.study.spring.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 2:18 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ApplicationContextAsIocContainer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextAsIocContainer.class);
        // 启用 applicationCOntext；
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user"));
    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge(18);
        user.setName("David");
        return user;
    }
}
