package com.david.study.spring.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 11:09 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: pojo
 * @since 1.0
 **/
public class User implements InitializingBean, DisposableBean {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public static User createUser(){
        User user = new User();
        user.setAge(18);
        user.setName("staticMethodIntantiaton");
        return user;
    }
    @PostConstruct
    public void init(){
        System.out.println("@postConstrcutMethod");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("@preDestory 销毁bean");
    }

    public void initialUserMethod(){
        System.out.println("@Bean initMethod ");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring initializingBean#afterPropertiesSet 方法");
    }

    public void destroy() throws Exception {
        System.out.println("Spring DisposableBean#destory()方法执行");
    }

    public void doDestroy(){
        System.out.println("自定义 destory方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("jvm 开始回收 User 对象");
    }
}
