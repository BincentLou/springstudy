package com.david.spring.study.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

/**
 * @version $Id: null.java, v 1.0 2020/5/26 7:00 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:外部化配置信息的注入，这个地方有个注意的点，计算机系统参数优先于工程参数注入 例如user.name
 * @since 1.0
 **/
@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties",encoding = "UTF-8")
public class EmbeddedPropertiesSourceDemo {


    @Value("${user.id}")
    private Long id ;

    @Value("${usr.name}")
    private String name;

    @Value("${user.source}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EmbeddedPropertiesSourceDemo.class);
        applicationContext.refresh();


        EmbeddedPropertiesSourceDemo demo = applicationContext.getBean(EmbeddedPropertiesSourceDemo.class);

        System.out.println(demo.id);
        System.out.println(demo.name);
        System.out.println(demo.resource);

        applicationContext.close();

    }
}
