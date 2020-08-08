package com.david.study.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/8/7 5:21 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:是一个注解的demo
 * @since 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface AnnotationDemo {

    String des() default "hello world";

}
