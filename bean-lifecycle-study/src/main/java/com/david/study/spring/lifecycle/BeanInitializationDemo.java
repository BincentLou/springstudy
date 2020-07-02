package com.david.study.spring.lifecycle;

import com.david.study.spring.domain.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @version $Id: null.java, v 1.0 2020/7/1 7:54 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:BeanPostProcessor的简单实现用例
 * @since 1.0
 **/
public class BeanInitializationDemo implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserHolder){
            UserHolder userHolder = (UserHolder) bean;
            System.out.println("初始化前调用 PostProcessorBeforeInitialiation");
            userHolder.setDescript("我经历过了postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserHolder){
            UserHolder userHolder = (UserHolder) bean;
            System.out.println("初始化后调用 postProcessorAfterInitialiation");
            userHolder.setDescript("我经历过了postProcessorAfterInitialiation");
        }
        return bean;
    }
}
