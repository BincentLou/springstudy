package com.david.study.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @version $Id: null.java, v 1.0 2020/8/11 10:42 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:Import的使用示例
 * @since 1.0
 **/
//@Import(AnnotationPojo.class) //引入一个@Component
//@Import(MyConfigurationDemo.class) //引入一个@Configuration
//@Import(MyImportSelector.class) //引入一个ImportSelector的实现类
@Import(MyImportBeanDefinitionRegistrar.class) //引入一个ImportBeanDefinitionRegistrar的实现类
public class ImportAnnotationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ImportAnnotationDemo.class);

        configApplicationContext.getBean(AnnotationPojo.class);
        configApplicationContext.close();
    }
}
