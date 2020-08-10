package com.david.study.spring.enable;

import com.david.study.spring.pojo.BeanDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 2:40 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: @Enable 注释的使用demo
 * @since 1.0
 **/
@EnableExPart
public class EnableExpartDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnableExpartDemo.class);

        BeanDemo beanDemo = applicationContext.getBean(BeanDemo.class);
        System.out.println(beanDemo);
        applicationContext.close();
    }
}
