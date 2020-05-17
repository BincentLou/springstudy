package com.david.study.spring.dependency.date;

/**
 * @version $Id: null.java, v 1.0 2020/5/17 2:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public enum CityEnum {
    HANGZHOU,
    SHANGHAI,
    SHENZHEN,
    GUANGZHOU;
    static CityEnum localByKey(String name){
       return CityEnum.valueOf(name);
    }
}
