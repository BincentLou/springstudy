package com.david.study.spring.lifecycle;

import com.david.study.spring.domain.UserHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:bean的生命周期，beanDefinition->实例化-》初始化demo
 * @since 1.0
 **/
@Configuration
public class AnnotationedBeanLifyCycleInBeanFactoryDemo {


    @Bean()
    public UserHolder userHolder(){
        return new UserHolder();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationedBeanLifyCycleInBeanFactoryDemo.class);


        applicationContext.close();
    }
}
