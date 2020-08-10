package com.david.study.spring.pojo;

import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 11:12 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Component
public class BeanDemo {

    private String name = "David";

    public String getName() {
        return name;
    }

    public BeanDemo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "BeanDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
