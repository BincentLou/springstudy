package com.david.study.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @version $Id: null.java, v 1.0 2020/7/28 11:04 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:@Validated 注解的demo，需要标注在class上，扫描到applicationContext中，cglib代理
 * @since 1.0
 **/
public class AnnotationValidatedDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/beans.xml");
        ProcessUser processUser = applicationContext.getBean(ProcessUser.class);
        processUser.process(new User());
        applicationContext.close();
    }

    @Component
    @Validated
    static class ProcessUser{
        public void process(@Valid User selfBean){
            System.out.println(selfBean);
        }
    }

    static class User{

        @NotNull(message = "nameNotNull")
        private String name;

        private Long id;

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Long getId() {
            return id;
        }

        public User setId(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
