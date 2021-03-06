package com.david.study.spring.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @version $Id: null.java, v 1.0 2020/7/13 9:48 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:命名空间的处理器
 * @since 1.0
 **/
public class SelfBeanNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("selfBean",new SelfBeanDefinitionParser());
    }
}
