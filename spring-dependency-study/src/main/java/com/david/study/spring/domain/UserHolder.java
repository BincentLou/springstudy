package com.david.study.spring.domain;

/**
 * @version $Id: null.java, v 1.0 2020/6/29 11:07 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class UserHolder {


    private int age;

    private String name;

    private String descript;

    public int getAge() {
        return age;
    }

    public UserHolder setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserHolder setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescript() {
        return descript;
    }

    public UserHolder setDescript(String descript) {
        this.descript = descript;
        return this;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                '}';
    }
}
