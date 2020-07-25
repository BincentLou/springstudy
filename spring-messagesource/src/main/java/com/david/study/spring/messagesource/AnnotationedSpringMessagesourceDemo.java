package com.david.study.spring.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Date;
import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2020/7/24 5:17 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
public class AnnotationedSpringMessagesourceDemo {

    @Bean
    MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message.format","message.message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.david.study.spring.messagesource");
        MessageSource messageSource = applicationContext.getBean(MessageSource.class);
        String message = messageSource.getMessage("message1", new Object[]{"david",new Date()},"Default",Locale.ENGLISH);
        System.out.println(message);
    }
}
