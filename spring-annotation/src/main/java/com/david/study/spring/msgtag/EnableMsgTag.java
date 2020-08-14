package com.david.study.spring.msgtag;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Import;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 5:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 启动MsgTag功能
 * @since 1.0
 **/

@Import(MsgTagConfiguration.class)
public @interface EnableMsgTag {
}
