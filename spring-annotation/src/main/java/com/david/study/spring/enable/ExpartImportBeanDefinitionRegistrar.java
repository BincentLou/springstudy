package com.david.study.spring.enable;

import com.david.study.spring.pojo.BeanDemo;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version $Id: ExpartImportBeanDefinitionRegistrar.java.java, v 1.0 2020/8/10 2:58 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 自定义的 ImportBeanDefinitionRegistrar
 * @since 1.0
 **/
public class ExpartImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotatedGenericBeanDefinition genericBeanDefinition = new AnnotatedGenericBeanDefinition(BeanDemo.class);
        BeanDefinitionReaderUtils.registerWithGeneratedName(genericBeanDefinition,registry);
    }
}
