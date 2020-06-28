package com.david.study.bean.lifecycle.study;

import java.math.BigDecimal;

/**
 * @version $Id: null.java, v 1.0 2020/6/28 11:26 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {
    public static void main(String[] args) {
        BigDecimal rateFloatValue = new BigDecimal(10);
//        String s = (BigDecimal.ONE.multiply(new BigDecimal(100)).add(rateFloatValue).divide(new BigDecimal(100))).setScale(5, BigDecimal.ROUND_HALF_UP).toString();

        String s = (BigDecimal.ONE.multiply(new BigDecimal(100)).add(rateFloatValue).divide(new BigDecimal(100))).setScale(5, BigDecimal.ROUND_HALF_UP).toString();

        System.out.println(s);
    }
}
