package com.david.study.spring.generic.message;

/**
 * @version $Id: null.java, v 1.0 2020/8/18 10:25 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MsgContent {

    String bizCode;

    public MsgContent(String bizCode) {
        this.bizCode = bizCode;
    }

    @Override
    public String toString() {
        return "MsgContent{" +
                "bizCode='" + bizCode + '\'' +
                '}';
    }
}
