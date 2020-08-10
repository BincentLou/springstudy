package com.david.study.spring.annotation;

import com.david.study.spring.pojo.BeanDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 11:03 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: ComponentScan 的扩展注解
 * @see ComponentScan
 * @since 1.0
 **/
@MyComponentScan(basePackages = "com.david.study.spring.pojo")
public class MyComponentScanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyComponentScanDemo.class);
        applicationContext.getBean(BeanDemo.class);
        applicationContext.close();
    }
}
