package com.david.study.spring.lifecycle;

import com.david.study.spring.domain.SuperUser;
import com.david.study.spring.domain.User;
import com.david.study.spring.domain.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: beanFactory中的createBean方法中，在resolveBeanClass之后，实例化之前，一个机会拦截bean的创建，返回代理对象
 * @since 1.0
 **/
public class BeanInstantiaitionAwareImpl implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        Assert.isNull(beanClass,"beanClass不能为空");
        System.out.println("实例化之前调用postProcessBeforeInstantiation方法");
        if(ObjectUtils.nullSafeEquals(beanClass, SuperUser.class)){
            SuperUser superUser = new SuperUser();
            superUser.setName("一个船新的版本");
            superUser.setAge(22);
            return superUser;
        }
        //默认什么都不做，返回null，继续下一步实例化
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("实例化后调用 postProcessAfterInstantiation方法");
        if(bean.getClass().equals(User.class)){
            User user = (User) bean;
            user.setName("至尊宝");
            user.setAge(589);
            return false;
        }
        //默认返回true，什么也不做，继续下一步 初始化
        return true;
    }


    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals(bean.getClass(), UserHolder.class)){
            UserHolder userHolder = (UserHolder) bean;
            System.out.println("populate bean 之前调用postProcessProperties 方法");
            if(pvs.contains("descript")){
                MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(pvs);
                mutablePropertyValues.removePropertyValue("descript");
                mutablePropertyValues.add("descript","至尊宝没带走我");
                return mutablePropertyValues;
            }

        }
        //默认返回null，什么也不做
        return null;
    }
}
