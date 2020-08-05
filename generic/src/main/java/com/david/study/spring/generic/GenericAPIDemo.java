package com.david.study.spring.generic;

import com.david.study.spring.generic.obj.StringAndStringMap;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 9:10 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class GenericAPIDemo {
    public static void main(String[] args) {
        //原生类型
        Class intClass = int.class;
        Class charClass = char.class;

        // 原始类型
        Class IntegerClass = Integer.class;

        //数组类型
        Class arrayClass = String[].class;

        //集合类型
        Class collectionClass = Collection.class;
        // 参数化类型
        ParameterizedType type = (ParameterizedType) StringAndStringMap.class.getGenericSuperclass();

        System.out.println(type);
        //真正的 参数类型
        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);
    }
}
