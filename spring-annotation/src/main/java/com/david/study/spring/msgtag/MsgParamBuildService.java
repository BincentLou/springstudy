package com.david.study.spring.msgtag;

/**
 * @version $Id: null.java, v 1.0 2020/8/14 10:04 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public interface MsgParamBuildService<T extends MsgBody> {

    T getMsgParam();

}
