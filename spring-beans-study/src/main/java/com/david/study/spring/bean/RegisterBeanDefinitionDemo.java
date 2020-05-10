package com.david.study.spring.bean;
import com.david.study.spring.domain.User;
import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIUserConversion;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 6:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Import(RegisterBeanDefinitionDemo.Config.class)
public class RegisterBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1。按照 @Bean注解 加载Bean
//        applicationContext.register(RegisterBeanDefinitionDemo.Config.class);

        //2。 按照 @Import方式
        applicationContext.register(RegisterBeanDefinitionDemo.class);

        //4.利用 API注入方式 加载
        registerUserByApi(applicationContext,"DavidRegisterByApi");
        registerUserByApi(applicationContext);
        applicationContext.refresh();
        Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
        Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);

        System.out.println("userMap:"+userMap);
        System.out.println("ConfigMap:"+configMap);
        applicationContext.close();
    }

    private static void registerUserByApi(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("age",29)
                .addPropertyValue("name","youngerDavid");
        if(StringUtils.isEmpty(beanName)){
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }else {
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }
    }
    private static void registerUserByApi(BeanDefinitionRegistry registry) {
        registerUserByApi(registry,null);
    }

    // 3。 按照@Component方式加载
    @Component
    public static class Config{

        @Bean
        public User use(){
            User user = new User();
            user.setAge(30);
            user.setName("DavidLou");
            return user;
        }
    }
}
