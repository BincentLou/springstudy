package com.david.study.spring.innerdependency;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.core.env.Environment;

import java.util.Iterator;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/10 9:29 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class InnerDependencyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InnerDependencyDemo.class);

        applicationContext.refresh();
        // environment inner bean
        getEnvironment(applicationContext);

        //messagesource inner bean
        getMessageSource(applicationContext);

        //lifecycleProcessor inner Bean
        getLifecycleProcessor(applicationContext);

        //applicationEventMuticaster
        getApplicationEventMuticaster(applicationContext);

        //ConfigurationClassPostProcessor ->BeanFactoryPostProcessor  不一定非要@Configuration
        getConfigurationClassPostProcessor(applicationContext);

        //AutowiredAnnotationBeanPostProcessor -> BeanPostProcessor  @Autowrire  @Value
        getAutowireAnnotationBeanPostProcessor(applicationContext);

        //CommonAnnotationBeanPostProcessor -> BeanPostProcessor  JSR-250注解 @PostConstruct @PreDestory
        getCommonAnnotationBeanPostProcessor(applicationContext);

        //EventListenerMethodPostProcessor -> BeanFactoryPostProcessor  @EventListener
        getEventListenerMethodPostProcessor(applicationContext);
        applicationContext.close();
    }

    private static void getEventListenerMethodPostProcessor(AnnotationConfigApplicationContext applicationContext) {
        Map<String, EventListenerMethodProcessor> environment = applicationContext.getBeansOfType(EventListenerMethodProcessor.class);
        Iterator<EventListenerMethodProcessor> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    private static void getCommonAnnotationBeanPostProcessor(AnnotationConfigApplicationContext applicationContext) {
        Map<String, CommonAnnotationBeanPostProcessor> environment = applicationContext.getBeansOfType(CommonAnnotationBeanPostProcessor.class);
        Iterator<CommonAnnotationBeanPostProcessor> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    private static void getAutowireAnnotationBeanPostProcessor(AnnotationConfigApplicationContext applicationContext) {
        Map<String, AutowiredAnnotationBeanPostProcessor> environment = applicationContext.getBeansOfType(AutowiredAnnotationBeanPostProcessor.class);
        Iterator<AutowiredAnnotationBeanPostProcessor> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    private static void getConfigurationClassPostProcessor(AnnotationConfigApplicationContext applicationContext) {
        Map<String, ConfigurationClassPostProcessor> environment = applicationContext.getBeansOfType(ConfigurationClassPostProcessor.class);
        Iterator<ConfigurationClassPostProcessor> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    private static void getApplicationEventMuticaster(AnnotationConfigApplicationContext applicationContext) {
        Map<String, ApplicationEventMulticaster> environment = applicationContext.getBeansOfType(ApplicationEventMulticaster.class);
        Iterator<ApplicationEventMulticaster> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    private static void getLifecycleProcessor(AnnotationConfigApplicationContext applicationContext) {
        Map<String, LifecycleProcessor> environment = applicationContext.getBeansOfType(LifecycleProcessor.class);
        Iterator<LifecycleProcessor> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    /**
     * 获取 MessageSource
     * @param applicationContext
     */
    private static void getMessageSource(AnnotationConfigApplicationContext applicationContext) {
        Map<String, MessageSource> environment = applicationContext.getBeansOfType(MessageSource.class);
        Iterator<MessageSource> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }

    /**
     * 获取Environment Inner Dependency Bean
     * @param applicationContext
     */
    private static void getEnvironment(AnnotationConfigApplicationContext applicationContext) {
        //外部化配置及profiles，包括systemProperties 和 systemEnvironment
        Map<String, Environment> environment = applicationContext.getBeansOfType(Environment.class);
        Iterator<Environment> iterator = environment.values().iterator();
        iterator.forEachRemaining(item->{System.out.println(item);});
    }
}
