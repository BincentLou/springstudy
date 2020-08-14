package com.david.study.spring.annotation;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version $Id: MyImportBeanDefinitionRegistrar.java.java, v 1.0 2020/8/11 10:57 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        AnnotatedGenericBeanDefinition annotationBeanDefinition = new AnnotatedGenericBeanDefinition(AnnotationPojo.class);
        BeanDefinitionReaderUtils.registerWithGeneratedName(annotationBeanDefinition,registry);

    }
}
