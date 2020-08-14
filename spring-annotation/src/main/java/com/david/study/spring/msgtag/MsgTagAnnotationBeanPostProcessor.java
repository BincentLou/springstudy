package com.david.study.spring.msgtag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 11:44 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:msgTag后处理器
 * @since 1.0
 **/
public class MsgTagAnnotationBeanPostProcessor implements BeanPostProcessor {

    Log logger = LogFactory.getLog(MsgTagAnnotationBeanPostProcessor.class);

    private final Set<Integer> registriesPostProcessed = new HashSet<>();

    private final Set<Integer> factoriesPostProcessed = new HashSet<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        int registryId = System.identityHashCode(bean);
        if (this.registriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanDefinitionRegistry already called on this post-processor against " + bean);
        }
        if (this.factoriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanFactory already called on this post-processor against " + bean);
        }
        this.registriesPostProcessed.add(registryId);
        processConfigBeanDefinitions(bean,beanName);
        return bean;
    }

    private void processConfigBeanDefinitions(Object bean,String beanName) {

        MsgClassParser parser = new MsgClassParser();


        parser.parse(bean,beanName);
    }
}

