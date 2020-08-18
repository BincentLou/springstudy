package com.david.study.spring.generic.message;

import org.springframework.util.Assert;

/**
 * @version $Id: null.java, v 1.0 2020/8/18 10:23 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MessageSendTemplate {

    public void sentMsg(String bizCode,BuildMsgContent buildMsgContent){

        MsgContent msgContent = buildMsgContent.buildMsgContent(bizCode);
        Assert.notNull(msgContent,"msgContent is null");
        System.out.println("发送短信+"+msgContent);
    }
}
