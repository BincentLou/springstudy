package com.david.study.spring.generic;

import com.david.study.spring.generic.obj.IntegerList;
import com.david.study.spring.generic.obj.StringAndStringMap;
import com.david.study.spring.generic.obj.StringList;
import org.springframework.core.ResolvableType;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 8:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ResolvableTypeDemo {
    public static void main(String[] args) {
        //展示集合的泛型
        displayCollectionGenericType(StringList.class);
        displayCollectionGenericType(IntegerList.class);

        // 展示bean的泛型
        displayGeneric(StringAndStringMap.class);

        //展示map的泛型
        displayMapGeneric();
    }

    private static void displayMapGeneric() {
        ResolvableType resolvableType = ResolvableType.forClass(StringAndStringMap.class);
        System.out.println(resolvableType.getRawClass());
        System.out.println(resolvableType.asMap().getGeneric(0));
        System.out.println(resolvableType.asMap().getGeneric(1));
    }

    private static void displayGeneric(Class claze) {
        ResolvableType resolvableType = ResolvableType.forClass(claze);
        System.out.println(resolvableType.getRawClass());
        System.out.println(resolvableType.getGeneric(0));
    }

    private static void displayCollectionGenericType(Class<?> claze) {
        ResolvableType resolvableType = ResolvableType.forClass(claze);
        System.out.println(resolvableType.getRawClass());
        System.out.println(resolvableType.asCollection().resolve());
        System.out.println(resolvableType.asCollection().getGeneric(0));
    }
}
