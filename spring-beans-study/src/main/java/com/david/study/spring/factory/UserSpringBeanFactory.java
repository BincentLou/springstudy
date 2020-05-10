package com.david.study.spring.factory;

import org.springframework.beans.factory.FactoryBean;
import com.david.study.spring.domain.User;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 8:38 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class UserSpringBeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User user = new User();
        user.setName("springBeanFactoryCreate");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
