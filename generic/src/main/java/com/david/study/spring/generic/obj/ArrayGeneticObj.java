package com.david.study.spring.generic.obj;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 11:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 实现类 也是这样，要继续在类名后紧跟<T>
 * @since 1.0
 **/
public class ArrayGeneticObj<T> extends AbstractGenericObj<T> {

    Object[] array ;

    @Override
    void setTargrt(T t) {

    }

    @Override
    public T getObj() {
        return null;
    }

    @Override
    public void setObj(T t) {

    }

    @Override
    public <T> void setTarget(T t1) {

    }
}
