package com.david.study.spring.generic.obj;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 10:58 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 声明一个泛型化参数类型的接口
 * @since 1.0
 **/
public interface GenericObj<T> {


    T getObj();

    void setObj(T t);

    /**
     * 申明一个泛型接口，确定在返回类型关键字之前要有<>泛型标志
     * @param t
     * @param <T>
     */
    <T> void setTarget(T t);

}
