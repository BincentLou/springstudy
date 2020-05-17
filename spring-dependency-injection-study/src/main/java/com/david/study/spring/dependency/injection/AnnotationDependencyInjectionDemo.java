package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.UserHolder;
import com.david.study.spring.dependency.date.CityEnum;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import com.david.study.spring.domain.*;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AnnotationDependencyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionReader beanDefinitionReader =new  XmlBeanDefinitionReader(annotationConfigApplicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-xml-injection.xml");

        annotationConfigApplicationContext.register(AnnotationDependencyInjectionDemo.class);

        annotationConfigApplicationContext.refresh();

        UserHolder userHolder = annotationConfigApplicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        annotationConfigApplicationContext.close();
    }


    @Bean
    public UserHolder userHolder(User user, CityEnum cityEnum){
        return new UserHolder(user,cityEnum);
    }
}
