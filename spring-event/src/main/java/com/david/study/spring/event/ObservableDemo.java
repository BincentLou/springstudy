package com.david.study.spring.event;

import java.util.Observable;
import java.util.Observer;

/**
 * @version $Id: null.java, v 1.0 2020/8/6 9:14 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:Observable demo
 * @since 1.0
 **/
public class ObservableDemo {
    public static void main(String[] args) {

        MyObservable observable = new MyObservable();
        observable.addObserver(new MyObserver());
        observable.setChanged();

    }


    static class MyObserver implements Observer{

        @Override
        public void update(Observable o, Object arg) {
            System.out.printf("监听到 对象：%s 发生了变化，传来消息 %s",o,arg);
        }
    }

    static class MyObservable extends Observable{

        @Override
        public synchronized void setChanged() {
            super.setChanged();
            super.notifyObservers("hello everybody");
            super.clearChanged();
        }
    }
}
