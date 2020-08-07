package com.david.study.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @version $Id: null.java, v 1.0 2020/8/6 4:26 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@EnableAsync
public class SpringEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringEventDemo.class);
        applicationContext.registerBean(MyRefreshEventListener.class);
        applicationContext.addApplicationListener(new MyApplicationListener());
        applicationContext.refresh();
//        applicationContext.start();

        MyRefreshEventListener myListener = applicationContext.getBean(MyRefreshEventListener.class);
        myListener.applicationEventPublisher.publishEvent("嘿嘿，我有一条新的消息");
//        applicationContext.stop();
        applicationContext.close();
    }

    static class MyApplicationListener implements ApplicationListener {



        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            System.out.printf("【线程 %s】",Thread.currentThread().getName());
            System.out.printf("监听到事件：%s。\n",event);
        }

    }

    static class MyRefreshEventListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationEventPublisherAware{

        public ApplicationEventPublisher applicationEventPublisher;

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.printf("【线程 %s】",Thread.currentThread().getName());
            System.out.printf("监听到上下文刷新事件：%s。\n",event);
        }


        @Override
        public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            this.applicationEventPublisher = applicationEventPublisher;

        }
    }

    @EventListener(value = {ContextStartedEvent.class})
    @Async
    void OnContextStartEvent(ApplicationEvent event){
        System.out.printf("【线程 %s】",Thread.currentThread().getName());
        System.out.printf("监听到上下文 启动事件：%s \n",event);
    }
}
