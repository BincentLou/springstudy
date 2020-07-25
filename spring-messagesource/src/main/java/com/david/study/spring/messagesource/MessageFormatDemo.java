package com.david.study.spring.messagesource;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2020/7/24 3:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MessageFormatDemo {

    public static void main(String[] args) {
        String desc = "有错误";

        int index = 3;

        Date now = new Date();

        String message = "at time {2,time,long} your code had a exception throw out a message : {0},at line no {1}";

        MessageFormat messageFormat = new MessageFormat(message);
        System.out.println(messageFormat.format(new Object[]{desc,index,now}));

        messageFormat.applyPattern(message);
        messageFormat.setLocale(Locale.ENGLISH);
        System.out.println(messageFormat.format(new Object[]{desc,index,now}));
    }
}
