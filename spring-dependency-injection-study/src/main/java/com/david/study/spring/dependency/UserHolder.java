package com.david.study.spring.dependency;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @version $Id: null.java, v 1.0 2020/5/15 9:23 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class UserHolder {

    @Resource
    private User user;

    public User getUser() {
        return user;
    }

    public UserHolder setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
