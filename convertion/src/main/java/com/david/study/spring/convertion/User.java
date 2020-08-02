package com.david.study.spring.convertion;

import java.util.Properties;

/**
 * @version $Id: null.java, v 1.0 2020/7/31 11:00 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class User {private String name;

    private Integer age;

    private Properties properties;

    public String getName() {
        return name;
    }

    public String property;

    public String getProperty() {
        return property;
    }

    public User setProperty(String property) {
        this.property = property;
        return this;
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

    public Properties getProperties() {
        return properties;
    }

    public User setProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", properties=" + properties +
                ", property='" + property + '\'' +
                '}';
    }
}