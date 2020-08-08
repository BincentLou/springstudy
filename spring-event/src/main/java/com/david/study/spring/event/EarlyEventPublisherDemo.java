package com.david.study.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @version $Id: null.java, v 1.0 2020/8/7 2:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class EarlyEventPublisherDemo implements ApplicationListener, BeanPostProcessor {

    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void publisherEvent(){
        applicationContext.publishEvent("Early Event published");
    }
    public static void main(String[] args) {
        GenericApplicationContext genericApplicationContext = new AnnotationConfigApplicationContext(EarlyEventPublisherDemo.class);

        genericApplicationContext.close();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.printf("监听到事件：%s。\n",event);
    }
}
