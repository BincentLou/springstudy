package com.david.study.spring.lookup;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/5/8 2:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:层次查找/
 * @since 1.0
 **/
public class HierarchicalBeanFactoryDemo {
    public static void main(String[] args) {

        //BeanFactory   <---   HierarchicalBeanFactory <-- ConfigurableBeanFactory  <--  ConfigurableListableBeanFactory
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        ConfigurableBeanFactory configurableBeanFactory =  classPathXmlApplicationContext.getBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalBeanFactoryDemo.class);
        ConfigurableBeanFactory hierarchicalBeanFactory = applicationContext.getBeanFactory();
        hierarchicalBeanFactory.setParentBeanFactory(configurableBeanFactory);

        applicationContext.refresh();

        System.out.println(hierarchicalBeanFactory.containsLocalBean("superUser"));
        System.out.println(hierarchicalBeanFactory.containsBean("superUser"));
    }
}
