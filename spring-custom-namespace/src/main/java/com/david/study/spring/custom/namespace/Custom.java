package com.david.study.spring.custom.namespace;

/**
 * @version $Id: null.java, v 1.0 2020/7/15 4:26 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$默认 custom标签解析成的 bean类型
 * @since 1.0
 **/
public class Custom {

    Integer age;

    Long id;

    String name;

    Sex sex;

    @Override
    public String toString() {
        return "Custom{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public Custom setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Custom setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Custom setName(String name) {
        this.name = name;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public Custom setSex(Sex sex) {
        this.sex = sex;
        return this;
    }
}

enum Sex{

    MELA,

    FEMALE;

}
