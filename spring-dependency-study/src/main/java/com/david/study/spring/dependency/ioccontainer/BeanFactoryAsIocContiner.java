package com.david.study.spring.dependency.ioccontainer;

import com.david.study.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @version $Id: null.java, v 1.0 2020/5/5 2:14 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class BeanFactoryAsIocContiner {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int a = reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");
        System.out.println("加载了："+a+"个bean");
        lookupByName(beanFactory);
    }

    private static void lookupByName(DefaultListableBeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
