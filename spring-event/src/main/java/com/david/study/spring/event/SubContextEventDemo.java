package com.david.study.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/8/7 1:50 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SubContextEventDemo implements ApplicationListener<ContextClosedEvent> {
    public static void main(String[] args) {
        GenericApplicationContext currentContext = new GenericApplicationContext();
        currentContext.setId("currentContext");
        currentContext.addApplicationListener(new SubContextEventDemo());
        GenericApplicationContext parentContext = new GenericApplicationContext();
        parentContext.setId("parentContext");
        parentContext.addApplicationListener(new SubContextEventDemo());

        currentContext.setParent(parentContext);

        parentContext.refresh();

        currentContext.refresh();

        parentContext.close();

        currentContext.close();

    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.printf("监听到上下文关闭事件：%s。\n",event.getApplicationContext().getId());
    }
}
