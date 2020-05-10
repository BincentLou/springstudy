package com.david.study.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 12:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:超级用户的注解
 * @since 1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Super {
}
