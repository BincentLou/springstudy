package com.david.study.spring.generic;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * @version $Id: null.java, v 1.0 2020/8/21 1:55 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Resource
public class ClassDemo<Long> implements Comparable{

    public static void main(String[] args) {
        Class<ClassDemo> clazs = ClassDemo.class;
        System.out.println("className:"+clazs.getName());
        System.out.println("simpleName:"+clazs.getSimpleName());
        System.out.print("interfaces :");
        Stream.of(clazs.getInterfaces()).forEach(System.out::println);
        System.out.println("canonicalName:"+clazs.getCanonicalName());
        System.out.println("typeName:"+clazs.getTypeName());
        System.out.println("GenericSuperclass typeName:"+clazs.getGenericSuperclass().getTypeName());
        System.out.println("annotation name:");
        Stream.of(clazs.getAnnotations()).forEach(System.out::println);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
