package com.david.study.spring.msgtag;

import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 11:42 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 普通的业务类
 * @since 1.0
 **/
@Component
public class BizServiceImpl implements BizService{

    @MsgTag(desc = "业务1",code = "BIZ1")
    @Override
    public String doBiz1() {
        return "doBiz1";

    }
    @MsgTag(desc = "业务2",code = "BIZ2")
    @Override
    public MsgBizCodeRegistry.MsgBizNameCode doBiz2() {
        return new MsgBizCodeRegistry.MsgBizNameCode("业务2","BIZ2");
    }
}
