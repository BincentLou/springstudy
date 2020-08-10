package com.david.study.spring.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 3:56 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:@Conditional 注解的使用demo
 * @see Conditional
 * Conditional的使用要结合Condition接口，实现matches方法
 * 在 ConfigurationClassPostProcessor里面，先处理了@Import再处理@ImportSource,第三步处理@ComponentScan
 * 之后 在处理完引入的注解之后，再调用ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(configClass);
 * 方法内部处理@Import和@Bean注解
 * loanBeanDefinitionsForBeanMethod方法 会调用当前的shouldSkip方法，查找Conditional注解的Condition接口
 * @since 1.0
 **/
@Configuration
public class ConditionalDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditionalDemo.class);

        ConfigurableEnvironment configurableEnvironment = context.getEnvironment();
        configurableEnvironment.setActiveProfiles("dev");
        configurableEnvironment.addActiveProfile("sit");

        context.refresh();
        System.out.println(context.getBean("tips",String.class));
        context.close();
    }


    @Bean(name="tips")
//    @Profile("dev")
    @Conditional(ProfileDevConditional.class)
    public String devTips(){
        return "devTips";
    }

    @Bean(name="tips")
    @Profile("sit")
    public String sitTips(){
        return "sitTips";
    }
}
