package com.david.spring.study.bean.scope;

import com.david.study.spring.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @version $Id: null.java, v 1.0 2020/6/18 8:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SelfScopeDemo {

    @Bean
    @Primary
//    @RequestScope
//    @SessionScope
    @Scope(ThreadScopeByDavid.THREAD_SCOPE)
    public static User singletonUser(){
        return getUser();
    }
    private static User getUser() {
        User user = new User();
        user.setId(System.nanoTime());
        user.setName("david");
        return user;
    }
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        
        applicationContext.register(SelfScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadScopeByDavid.THREAD_SCOPE,new ThreadScopeByDavid());
        });

        applicationContext.refresh();

        for (int i =0 ; i<3;i++){
            Thread thread = new Thread(()->{
                testSelfScopeByLookup(applicationContext);
            });
            thread.start();
        }
        
        testSelfScopeByLookup(applicationContext);
        
        applicationContext.close();
        
    }

    private static void testSelfScopeByLookup(AnnotationConfigApplicationContext applicationContext) {
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
