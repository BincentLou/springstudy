package com.david.spring.study.bean.scope;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/6/1 9:41 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:bean的作用域用例
 * @since 1.0
 **/
@Configuration
public class BeanScopeDemo implements DisposableBean {

    @Bean
    @Primary
//    @RequestScope
//    @SessionScope
    @ApplicationScope
    public static User singletonUser(){
        return getUser();
    }
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public static User protoTypeUser(){
//        return getUser();
//    }

    private static User getUser() {
        User user = new User();
        user.setId(System.nanoTime());
        user.setName("david");
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;


    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;


//    @Autowired
//    @Qualifier("protoTypeUser")
//    private User protoTypeUser;
//
//    @Autowired
//    @Qualifier("protoTypeUser")
//    private User protoTypeUser1;
//
//    @Autowired
//    @Qualifier("protoTypeUser")
//    private User protoTypeUser2;

    @Autowired
    private Map<String,User> userMap;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(BeanScopeDemo.class);
//
//        applicationContext.refresh();
//
//        lookeUpBeanScopeDemo(applicationContext);
//        injectBeanScopeDemo(applicationContext);
////        applicationContext.close();
//
//
//    }

    private static void lookeUpBeanScopeDemo(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("looke up singletonUser = "+applicationContext.getBean("singletonUser",User.class));
        System.out.println("looke up singletonUser2 = "+applicationContext.getBean("singletonUser",User.class));
        System.out.println("looke up protoTypeUser = "+applicationContext.getBean("protoTypeUser",User.class));
        System.out.println("looke up protoTypeUser1 = "+applicationContext.getBean("protoTypeUser",User.class));
        System.out.println("looke up protoTypeUser2 = "+applicationContext.getBean("protoTypeUser",User.class));
    }

    private static void injectBeanScopeDemo(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("inject singletonUser = "+beanScopeDemo.singletonUser);
        System.out.println("inject singletonUser1 = "+beanScopeDemo.singletonUser1);
//        System.out.println("inject protoTypeUser = "+beanScopeDemo.protoTypeUser);
//        System.out.println("inject protoTypeUser1 = "+beanScopeDemo.protoTypeUser1);
//        System.out.println("inject protoTypeUser2 = "+beanScopeDemo.protoTypeUser2);
    }

    @Override
    public void destroy() throws Exception {
//        this.protoTypeUser.destory();
//        this.protoTypeUser1.destory();
//        this.protoTypeUser2.destory();
        for (Map.Entry<String,User> entry:userMap.entrySet()
             ) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(entry.getKey());
            if(beanDefinition.isPrototype()){
                entry.getValue().destory();
            }
        }
    }
}
