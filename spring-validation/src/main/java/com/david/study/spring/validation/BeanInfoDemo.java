package com.david.study.spring.validation;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @version $Id: null.java, v 1.0 2020/7/28 3:27 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:java rt 包内的BeanInfo java虚拟机自带的bean反射之后的描述对象
 * @since 1.0
 **/
public class BeanInfoDemo {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public BeanInfoDemo setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(BeanInfoDemo.class,Object.class);

        System.out.println(beanInfo.getBeanDescriptor());
        Stream.of(beanInfo.getMethodDescriptors()).forEach(methodDescriptor -> {System.out.println(methodDescriptor);});
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {System.out.println(propertyDescriptor);});
    }
}
