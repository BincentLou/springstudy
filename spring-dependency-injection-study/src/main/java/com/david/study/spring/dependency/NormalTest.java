package com.david.study.spring.dependency;

import org.springframework.util.ReflectionUtils;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2020/5/15 8:59 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testHashMap();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testHashtable();
            }
        });

        b.start();
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private static void testHashtable() {
        long a = System.currentTimeMillis();
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        for(int i=0;i<1000000;i++){
            hashtable.put(i,i);
        }
        for(int i=1000000;i>500000;i--){
            hashtable.get(i);
        }
        System.out.println("----------Hastable-----------");
        System.out.println(System.currentTimeMillis()-a);
    }

    private static void testHashMap() {
        long a = System.currentTimeMillis();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<1000000;i++){
            hashMap.put(i,i);
        }
        for(int i=1000000;i>500000;i--){
            hashMap.get(i);
        }
        System.out.println("-----------HashMap----------");
        System.out.println(System.currentTimeMillis()-a);
    }

}
