package com.david.study.spring.msgtag;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 2:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/

@Aspect
@Component
public class MsgTagAOP {

    @Pointcut("@annotation(com.david.study.spring.msgtag.MsgTag)")
    public void pointCut(){

    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void after(JoinPoint joinPoint, Object result) throws Throwable {
        Object target = joinPoint.getTarget();
        Class<?> clazs = AopUtils.getTargetClass(target);
        Method methodq = Stream.of(clazs.getDeclaredMethods())
                .filter(method -> {return method.getName().equals(joinPoint.getSignature().getName());})
                .findFirst()
                .get();
        MsgTag msgTag = AnnotationUtils.findAnnotation(methodq, MsgTag.class);
        System.out.printf("发送短信：%s",msgTag.code());
    }

}
