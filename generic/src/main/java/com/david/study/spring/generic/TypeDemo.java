package com.david.study.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @version $Id: null.java, v 1.0 2020/8/21 1:45 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class TypeDemo {

    public static void main(String[] args) {

        Class clazs =  TypeList.class;
        System.out.println(clazs.getTypeName());

        Type clazeType = clazs.getGenericSuperclass();
        System.out.println(clazeType.getTypeName());


        if(clazeType instanceof ParameterizedType){
            System.out.println(clazeType.getTypeName());
        }
    }

    static class TypeList extends ArrayList implements Comparable {

        private static final long serialVersionUID = -8554520510527287057L;

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
