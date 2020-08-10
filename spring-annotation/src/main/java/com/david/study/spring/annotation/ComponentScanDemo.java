package com.david.study.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version $Id: null.java, v 1.0 2020/8/8 8:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
@ComponentScan(basePackages = "com.david.study.spring.annotation")
public class ComponentScanDemo {

    public static void main(String[] args) {
        // 1 构造方法的入参是一个类，会被AnnotatedBeanDefinitionReader.register 当作是一个BeanDefinition注册到容器中
        // 2 当上下文AbstractAppplicationContext执行refresh方法的时候，会调用invokeBeanFactoryPostProcessors方法，执行beanFactory的后处理
        // 3 上下文会委托 PostProcessorRegistrationDelegate 来执行 BeanFactoryPostProcessor的后处理方法
        // 4 ConfigurationClassPostProcessor 实现了 BeanDefinitionRegistryPostProcessor <- BeanFactoryPostProcessor,执行postProcessorBeanDefinitionRegistry()方法
        // 5 ConfigurationClassPostProcessor 调用 processConfigBeanDefinitions方法 解析所有的Configuration
        // 6 ConfigurationClassParser 解析器解析 单个ConfigutationClass
        /**
         * 7 ConfigurationClassParser 分类解析ConfigurationClass 1-是否@Component
         *   2-是否 @PropertySource
         *   3-是否 @ComponentScane
         *   4-是否 @Import
         *   5-是否 @ImportSource
         *   6-是否 @Bean
         *   7-执行defaultMethod
         *   8-处理超类
         * 8 ComponentScanAnnotationParser#parser()
         * 9 新建ClasspathBeanDefinitionScanner#doScan()
         * 10 ClassPathScanningCandidateComponentProvider#findCandidateComponents(String basePackage) 会委托PathMatchingResourcePatternResolver解决多路径扫描
         * 11 使用ASM (v-5.0才有的) 或者反射 获取BeanDefinition
         * ASM和反射的最大区别就是 ASM直接读取字节码，不用把类加载到虚拟机，节约新能，
         * 12 获取的BeanDefinition 注册到容器
         *   */

//
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ComponentScanDemo.class);
        configApplicationContext.register(AnnotationPojo.class);
        configApplicationContext.close();
    }
}
