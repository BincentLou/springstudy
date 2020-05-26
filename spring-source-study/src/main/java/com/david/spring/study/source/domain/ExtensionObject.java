package com.david.spring.study.source.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @version $Id: null.java, v 1.0 2020/5/26 6:37 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ExtensionObject implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("接口回调");
    }
}
