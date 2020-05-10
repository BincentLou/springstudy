package com.david.study.spring.domain;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 12:42 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class UserRepository {
    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public UserRepository setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
        return this;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public UserRepository setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        return this;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public UserRepository setUsers(Collection<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
