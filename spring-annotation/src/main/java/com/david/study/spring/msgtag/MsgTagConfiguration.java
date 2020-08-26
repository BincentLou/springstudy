package com.david.study.spring.msgtag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: MsgTagConfiguration.java.java, v 1.0 2020/8/13 5:34 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
//@ConditionalOnBean(AnnotationAwareAspectJAutoProxyCreator.class)
@Configuration
public class MsgTagConfiguration {
    @Bean
    public MsgTagAnnotationBeanPostProcessor msgTagAnnotationBeanPostProcessor(){
        return new MsgTagAnnotationBeanPostProcessor();
    }
}
