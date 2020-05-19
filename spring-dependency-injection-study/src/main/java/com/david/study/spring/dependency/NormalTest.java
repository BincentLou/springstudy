package com.david.study.spring.dependency;

import org.springframework.util.ReflectionUtils;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2020/5/15 8:59 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {
    private static Unsafe unsafe;
    public static void main(String[] args) {
        try {
            Field field = ReflectionUtils.findField(Unsafe.class,"theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(unsafe.addressSize());

    }

    private static void createThreadAndUpdateAtomicInteger(AtomicInteger atomicInteger) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.getAndIncrement();
            }
        });
        thread.start();
    }
}
