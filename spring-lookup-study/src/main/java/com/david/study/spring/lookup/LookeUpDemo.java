package com.david.study.spring.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @version $Id: null.java, v 1.0 2020/5/6 10:44 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:lookeUpDemo
 * @since 1.0
 **/
public class LookeUpDemo {

    public static void main(String[] args) {
        //1.立即查找
        //2.延迟查找
        //3.单例查找
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LookeUpDemo.class);// 可以不标注@Configuration注解，直接解析
        //启动上下文
        applicationContext.refresh();
//        String sysName =  applicationContext.getBean("systemName",String.class);
//        System.out.println(sysName);


        //延迟查找
        lookUpByProvider(applicationContext);

        applicationContext.close();
    }

    private static void lookUpByProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }


    //bean 可以是String类型的，
    @Bean
    public String systemName(){
        return "DavidStudy";
    }
}
