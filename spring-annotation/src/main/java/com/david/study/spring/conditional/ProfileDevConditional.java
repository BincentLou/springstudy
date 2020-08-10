package com.david.study.spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 3:52 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 判断Environment 的ActiveProfile的属性
 * @since 1.0
 **/
public class ProfileDevConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().acceptsProfiles("dev");
    }
}
