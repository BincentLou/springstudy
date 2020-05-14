package com.david.study.spring.beansexception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @version $Id: null.java, v 1.0 2020/5/11 10:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeansExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeansExceptionDemo.class);

//        beanInstantiationException(applicationContext);
        applicationContext.refresh();

        // NoSuchBeanException -> BeansException -> RuntimeException
//        noSuchBeanException(applicationContext);

        // NoUniqueBeanDefinitionException -> NoSuchBeanException
//        noUniqueBeanDefinitionException(applicationContext);


        applicationContext.close();
    }


    private static void beanCreationException(AnnotationConfigApplicationContext applicationContext) {
        String bean = applicationContext.getBean(String.class);
    }

    private static void noUniqueBeanDefinitionException(AnnotationConfigApplicationContext applicationContext) {
        String bean = applicationContext.getBean(String.class);
    }

    private static void beanInstantiationException(AnnotationConfigApplicationContext applicationContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        applicationContext.registerBeanDefinition("abstractBean",beanDefinition);
    }

    static class CreationException implements InitializingBean{

        @PostConstruct
        public void init() throws Exception {
            throw new Exception("哈哈");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("嘿嘿");
        }
    }

    @Bean
    public static CreationException creationException(){
        return new CreationException();
    }

    @Bean
    public static String message1(){
        return "Bean1";
    }

    @Bean
    public static String message2(){
        return "Bean2";
    }
    /**
     *  No Such Bean Exception
     * @param applicationContext
     */
    private static void noSuchBeanException(AnnotationConfigApplicationContext applicationContext) {
        Object bean = applicationContext.getBean("NoSuchBean");
        System.out.println(bean);
    }
}
