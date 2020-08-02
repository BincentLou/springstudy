package com.david.study.spring.convertion;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.GenericConverter;

/**
 * @version $Id: null.java, v 1.0 2020/8/2 5:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:spring3之后推荐使用Converter接口
 * @see ConditionalConverter
 * @see ConditionalGenericConverter
 * @see GenericConverter
 * 自定义的convertor要注册到上下文中，需要饮用ConversionServiceFactoryBean
 * @see ConversionServiceFactoryBean
 *
 * @since 1.0
 **/
public class SpringConverterDemo {

    /**
     * beanDefinition->bean的时候会新建BeanWrapper-->BeanWrapperImpl-->
     * TypeConverterDelegate-->PropertyEditorRegistry-->ConversionService-->ConditionalGenericConverter
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/convertion-context.xml");
        //
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        applicationContext.close();
    }
}
