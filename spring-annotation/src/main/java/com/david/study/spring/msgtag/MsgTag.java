package com.david.study.spring.msgtag;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 11:36 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 消息埋点注解
 * @since 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MsgTag {

    /**
     * 业务描述，比如：放款成功通知
     * @return
     */
    String desc() default  "";

    /**
     * 业务编码，比如自定义业务编码：ZEUS_FKCGTZ
     * @return
     */
    String code() ;

}
