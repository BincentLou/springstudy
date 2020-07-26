package com.david.study.spring.messagesource;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2020/7/25 11:27 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:spring boot 启动中会自动注册一个 messageSource
 * @since 1.0
 **/
@EnableAutoConfiguration
public class SpringBootMessageSourceDemo {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("message.format","message.message");
        return messageSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringBootMessageSourceDemo.class)
                .web(WebApplicationType.NONE)
                .run(args);
        MessageSource messageSource = applicationContext.getBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, MessageSource.class);
        System.out.println(messageSource);
        System.out.println(messageSource.getMessage("message1",new Object[]{} , Locale.getDefault()));
        applicationContext.close();
    }
}
