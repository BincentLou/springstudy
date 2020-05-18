package com.david.study.spring.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @version $Id: null.java, v 1.0 2020/5/17 9:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ApiUser implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring initializingBean#afterPropertiesSet 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring DisposableBean#destory()方法执行");
    }
    @PostConstruct
    public void init(){
        System.out.println("@postConstrcutMethod");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("@preDestory 销毁bean");
    }

}
