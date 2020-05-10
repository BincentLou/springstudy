package com.david.study.spring.domain;

import com.david.study.spring.annotation.Super;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 11:27 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public SuperUser setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
