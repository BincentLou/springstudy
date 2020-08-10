package com.david.study.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 11:02 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的 Component Scan
 * @since 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface MyComponentScan {

    /**
     * 属性覆盖
     * @return
     */
    String[] value() default {};

    /**
     *
     * 别名 显示覆盖
     * @return
     */
    @AliasFor(annotation = ComponentScan.class)
    String[] basePackages() default {};
}
