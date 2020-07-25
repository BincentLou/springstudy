package com.david.study.spring.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2020/7/24 5:17 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class XmlSpringMessagesourceDemo {

    public static void main(String[] args) {

        MessageSource messageSource = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        String message = messageSource.getMessage("message1", new Object[]{"david",new Date()},"Default",Locale.ENGLISH);
        System.out.println(message);
        String message1 = messageSource.getMessage("message1", new Object[]{"david",new Date()},"Default",Locale.SIMPLIFIED_CHINESE);
        System.out.println(message1);
    }
}
