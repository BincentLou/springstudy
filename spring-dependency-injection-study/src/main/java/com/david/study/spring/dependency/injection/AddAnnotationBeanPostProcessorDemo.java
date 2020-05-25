package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.annotation.MyAutowiredExt;
import com.david.study.spring.dependency.annotation.MyNewAnnotation;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @version $Id: null.java, v 1.0 2020/5/22 1:27 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AddAnnotationBeanPostProcessorDemo {

    @MyNewAnnotation
    private User user;

    @Autowired
    private User user1;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AddAnnotationBeanPostProcessorDemo.class);

        applicationContext.refresh();
        AddAnnotationBeanPostProcessorDemo demo = applicationContext.getBean(AddAnnotationBeanPostProcessorDemo.class);
        System.out.println(demo.user);
        System.out.println(demo.user1);




        applicationContext.close();
    }

    @Bean
    public User user(){
        return User.createUser();
    }

    /**
     * 新注入一个AutowiredeAnnotationBeanPostProcessor。来专门注入MyNewAnnotation注解，
     * 这个地方有个特别的是 1。该方法是static，保证此Bean要在applicationContext的refresh之前就会被初始化。
     * 2；该注解处理器的名称，跟
     * 3；该方法的Order注解标注了该注解处理器的执行顺序，比原始的，可以比原始的AutowiredAnnotationBeanPostProcessor更早
     * @return
     */
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE -4)
    public static AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor(){
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationType(MyNewAnnotation.class);
//        HashSet<Class<? extends Annotation>> types = new HashSet<>(Arrays.asList(Autowired.class,MyNewAnnotation.class));
//        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationTypes(types);
        return autowiredAnnotationBeanPostProcessor;
    }
}
