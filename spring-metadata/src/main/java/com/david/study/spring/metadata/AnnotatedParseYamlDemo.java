package com.david.study.spring.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @version $Id: null.java, v 1.0 2020/7/19 12:49 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/

@PropertySource(name = "yamlProperties",
                value = "bean.yaml",
                factory =YamlPropertySourceFactory.class)
public class AnnotatedParseYamlDemo {


    @Bean
    public SelfBean selfBean(@Value("${selfBean.id}") Long id , @Value("${selfBean.name}") String name){
        SelfBean selfBean = new SelfBean();
        selfBean.setId(id);
        selfBean.setName(name);
        return selfBean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedParseYamlDemo.class);
        applicationContext.refresh();
        SelfBean selfBean =  applicationContext.getBean("selfBean",SelfBean.class);
        System.out.println(selfBean);
        applicationContext.close();


    }
}
