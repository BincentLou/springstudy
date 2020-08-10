package com.david.study.spring.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 2:02 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: @Enable*** 的示例 相当于开关，开启某部分功能
 * 三种方法
 * 1：使用@Import 导入我们的特定的配置文件Configuration
 * 2:使用 @Import 导入实现了ImportSelector的类
 * 3:继承 ImportBeanDefinitionRegistrar
 * @since 1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ExPartConfiguration.class) // 第一种方式
//@Import(ExpartImportSelector.class)  // 第二种方式
@Import(ExpartImportBeanDefinitionRegistrar.class)// 第三种方式
public @interface EnableExPart {
}
