package com.david.study.spring.msgtag;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version $Id: MsgTagImportBeanDefinitionRegistrar.java.java, v 1.0 2020/8/13 5:27 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
public class MsgTagImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(MsgTagAnnotationBeanPostProcessor.class);
        BeanDefinitionReaderUtils.registerBeanDefinition(new BeanDefinitionHolder(annotatedGenericBeanDefinition,importingClassMetadata.getClassName()),registry);
    }
}
