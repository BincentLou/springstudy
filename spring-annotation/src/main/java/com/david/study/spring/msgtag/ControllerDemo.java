package com.david.study.spring.msgtag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 2:56 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Component
public class ControllerDemo {

    @Autowired
    private BizService bizService;


    public void invokeBiz(){
        bizService.doBiz1();
        bizService.doBiz2();
    }
}
