package com.david.study.spring.event;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @version $Id: null.java, v 1.0 2020/8/6 9:33 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class EventObjectAndListener {

    public static void main(String[] args) {

        MyEventListener eventListener = new ListenerImpl();
        eventListener.onEvent(new MyEventObject("嘿嘿 ，有消息来咯"));

    }

    interface MyEventListener extends EventListener{
        void onEvent(EventObject eventObject);
    }

    static class MyEventObject extends EventObject{

        private static final long serialVersionUID = 5320511510333017973L;

        /**
         * Constructs a prototypical Event.
         *
         * @param source The object on which the Event initially occurred.
         * @throws IllegalArgumentException if source is null.
         */
        public MyEventObject(Object source) {
            super(source);
        }
    }

    static class ListenerImpl implements MyEventListener{

        @Override
        public void onEvent(EventObject eventObject) {
            System.out.printf("监听到消息：%s",eventObject);
        }
    }
}
