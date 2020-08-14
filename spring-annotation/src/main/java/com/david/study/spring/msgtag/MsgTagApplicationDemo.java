package com.david.study.spring.msgtag;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 1:48 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@ComponentScan("com.david.study.spring.msgtag")
@EnableMsgTag
public class MsgTagApplicationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MsgTagApplicationDemo.class);

        MsgBizCodeRegistry.getBizCodeList().forEach(System.out::println);
        ControllerDemo controllerDemo = configApplicationContext.getBean(ControllerDemo.class);
        controllerDemo.invokeBiz();
        configApplicationContext.close();
    }

}
