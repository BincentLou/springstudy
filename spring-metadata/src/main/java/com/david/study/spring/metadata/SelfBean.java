package com.david.study.spring.metadata;

/**
 * @version $Id: null.java, v 1.0 2020/7/13 9:51 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:pojo
 * @since 1.0
 **/
public class SelfBean {

    private Long id;

    private String name;

    private City city;

    public Long getId() {
        return id;
    }

    public SelfBean setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SelfBean setName(String name) {
        this.name = name;
        return this;
    }

    public City getCity() {
        return city;
    }

    public SelfBean setCity(City city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return "SelfBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
