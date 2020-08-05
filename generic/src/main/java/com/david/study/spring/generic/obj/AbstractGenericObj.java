package com.david.study.spring.generic.obj;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 11:01 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:实现泛型接口，又不想指定泛型化参数类型，那么就要在命名的时候，带上全部的泛型参数 即在Class后面标注<>
 * @since 1.0
 **/
public abstract class AbstractGenericObj<T> implements GenericObj<T> {

    abstract void setTargrt(T t);

}
