package com.david.study.spring.generic.message;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @version $Id: null.java, v 1.0 2020/8/18 10:30 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MsgSendTemplateDemo {

    @Bean
    MessageSendTemplate messageSendTemplate(){
        return new MessageSendTemplate();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MsgSendTemplateDemo.class);

        MessageSendTemplate msgSendTemplate = context.getBean(MessageSendTemplate.class);
        msgSendTemplate.sentMsg("100", new BuildMsgContent() {
            @Override
            public MsgContent buildMsgContent(String bizCode) {
                return new MsgContent(bizCode);
            }
        });

        context.close();
    }
}
