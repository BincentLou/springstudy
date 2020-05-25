package com.david.spring.study.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @version $Id: null.java, v 1.0 2020/5/25 2:52 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DependencySourceDemo {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void initInject(){
        /**
         * @see org.springframework.context.support.AbstractApplicationContext prepareBeanFatory方法
         * 在AbstractApplicationContext的 prepareBeanFactory的时候，会默认注入resolvableDependency的四个对象
         * 1；beanFactory，2ResourceLoade,2ApplicationContext,4ApplicationEventPublisher
         * 但是四个对象不在BeanFactory的单利beanMap中，所以在自动注入的时候能查找到，但是在beanFactory.getBean()会找不到
         */
        System.out.println("beanFactory == ApplicationContext "+(beanFactory == applicationContext));
        System.out.println("resourceLoader == ApplicationContext "+(resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == ApplicationContext "+(applicationEventPublisher == applicationContext));
        System.out.println("applicationContext == ApplicationContext "+(applicationContext == applicationContext));
    }

    @PostConstruct
    public void getBean(){
        /**
         * ApplicationContext 的getBean(Class<?>type),查找范围是allBeanNamesByType 和 signletonBeanNamesByType 两个map，
         * 不包括resovlableDependencymap；
         */
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    private void getBean(Class clzs) {
        try{
            applicationContext.getBean(clzs);
        }catch (Exception e){
            System.out.println("can't find "+ clzs);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);
        applicationContext.refresh();



        applicationContext.close();
    }
}
