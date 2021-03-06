package com.david.study.spring.dependency.injection;

import com.david.study.spring.dependency.UserHolder;
import com.david.study.spring.dependency.date.CityEnum;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version $Id: null.java, v 1.0 2020/5/14 11:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:xml 文件配置context 可以注入 enum  可以注入resource,可以注入List array map
 * @since 1.0
 **/
public class XmlDependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-xml-injection.xml");
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }

}
