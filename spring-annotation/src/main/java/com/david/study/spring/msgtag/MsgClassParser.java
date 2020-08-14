package com.david.study.spring.msgtag;

import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.stream.Stream;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 1:28 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MsgClassParser {

    protected final void parse(Object bean, String className){
        Class claz = AopUtils.getTargetClass(bean);
        Stream.of(claz.getDeclaredMethods()).forEach(method->{
            MsgTag msgTag = AnnotationUtils.findAnnotation(method, MsgTag.class);
            if(msgTag==null){
                return;
            }
            MsgBizCodeRegistry.addMsgBizCode(msgTag.desc(),msgTag.code());
        });

    }



}
