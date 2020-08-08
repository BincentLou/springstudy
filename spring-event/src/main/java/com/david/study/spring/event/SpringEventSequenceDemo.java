package com.david.study.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/8/7 1:29 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SpringEventSequenceDemo implements ApplicationListener {
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        applicationContext.addApplicationListener(new SpringEventSequenceDemo());
        applicationContext.addApplicationListener(new ContextCloaseEventListener());

        applicationContext.refresh();

//        ApplicationEventPublisher applicationListener = applicationContext.getBean(ApplicationEventPublisher.class);
        applicationContext.start();
        applicationContext.stop();
        applicationContext.close();

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.printf("监听到事件：%s。\n",event);
    }

    static class ContextCloaseEventListener implements ApplicationListener<ContextClosedEvent>{

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.printf("监听到上线文关闭事件：%s。\n",event);
        }
    }
}
