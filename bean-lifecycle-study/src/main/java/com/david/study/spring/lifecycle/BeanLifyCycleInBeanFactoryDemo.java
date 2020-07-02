package com.david.study.spring.lifecycle;

import com.david.study.spring.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:bean的生命周期，beanDefinition->实例化-》初始化demo
 * @since 1.0
 **/
public class BeanLifyCycleInBeanFactoryDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // beanPostProcessor只能手动添加到beanFactory,不像applicationContext可以自己修改beanfactory的BeanPostProcessor
        beanFactory.addBeanPostProcessor(new BeanInitializationDemo());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");
        UserHolder userHolder =  (UserHolder)beanFactory.getBean("userHolder");
        System.out.println(userHolder);
    }
}
