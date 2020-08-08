package com.david.study.spring.annotation;

import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2020/8/8 10:28 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@AnnotationDemo(des = "你好")
@Component
public class AnnotationPojo {

    public static void main(String[] args) {
        System.out.println("哈哈哈");
    }
}
