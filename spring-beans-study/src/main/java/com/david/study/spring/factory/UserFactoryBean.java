package com.david.study.spring.factory;

import com.david.study.spring.domain.User;
/**
 * @version $Id: null.java, v 1.0 2020/5/5 8:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public interface UserFactoryBean {
    default User createUser(){

        return new User();
    }
}
