package com.david.study.spring.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2020/8/4 9:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class GenericDemo {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("111");
        List b = a;
//        a.add(1);
        b.add(1);
        System.out.println(a.get(1));

    }
}
