package com.david.study.spring.domain;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 11:09 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: pojo
 * @since 1.0
 **/
public class User implements BeanNameAware {

    private String name;

    private Integer age;

    private Long id;

    private transient String beanName;

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
                ", age=" + age +
                ", id=" + id +
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

    public void initialUserMethod(){
        System.out.println("@Bean initMethod ");
    }

    public void doDestroy(){
        System.out.println("自定义 destory方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("jvm 开始回收 User 对象");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @PostConstruct
    public void init(){
        System.out.println(beanName + "初始化");
    }

    @PreDestroy
    public void destory(){
        System.out.println(beanName + "销毁");
    }
}
