package com.david.study.spring.dependency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version $Id: null.java, v 1.0 2020/5/15 8:59 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(100);
        for (int i=0;i<10;i++) {
            createThreadAndUpdateAtomicInteger(atomicInteger);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        System.out.println(atomicInteger.get());
    }

    private static void createThreadAndUpdateAtomicInteger(AtomicInteger atomicInteger) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!atomicInteger.compareAndSet(atomicInteger.get()+1,atomicInteger.get())){

                }
                return;
            }
        });
        thread.start();
    }
}
