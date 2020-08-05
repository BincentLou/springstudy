package com.david.study.spring.generic;

import com.david.study.spring.generic.obj.ArrayGeneticObj;
import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 8:38 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class GenericTypeResolverDemo<T> {


    public static void main(String[] args) throws NoSuchMethodException {


        displayMethodReturnType("getStringArrayGenenric",GenericTypeResolverDemo.class);
        displayMethodReturnType("getObj",GenericTypeResolverDemo.class);
        displayMethodReturnType("getObjt",GenericTypeResolverDemo.class);
        displayMethodReturnType("getObjList",GenericTypeResolverDemo.class);


        Map<TypeVariable, Type> map = GenericTypeResolver.getTypeVariableMap(IntegerArrayGeneric.class);
        System.out.println(map);
    }


    static class IntegerArrayGeneric extends ArrayGeneticObj<String>{

    }

    private static ArrayGeneticObj getStringArrayGenenric(){
        return null;
    }

    private static void getObjt(){

    }

    private static List getObjList(){
        return new ArrayList<String>();
    }

    private T getObj(){
        return null;
    }

    static void displayMethodReturnType(String methodName,Class tarClass,Class... paramClass) throws NoSuchMethodException {
        Method method = tarClass.getDeclaredMethod(methodName,paramClass);

        Class<?> claze = GenericTypeResolver.resolveReturnType(method,tarClass);
        System.out.println(claze);
    }
}
