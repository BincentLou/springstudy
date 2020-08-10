package com.david.study.spring.enable;

import com.david.study.spring.pojo.BeanDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 2:38 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义扩展模块的配置参数
 * @since 1.0
 **/
@Configuration
public class ExPartConfiguration {

    @Bean
    BeanDemo beanDemo(){
        return new BeanDemo();
    }
}
