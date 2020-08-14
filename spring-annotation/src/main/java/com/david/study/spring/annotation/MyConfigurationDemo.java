package com.david.study.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2020/8/11 10:45 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
public class MyConfigurationDemo {
    @Bean
    public  AnnotationPojo annotationPojo(){
        return new AnnotationPojo();
    }
}
