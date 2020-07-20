package com.david.study.spring.custom.namespace;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @version $Id: null.java, v 1.0 2020/7/15 4:42 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$ custom 命名空间的解析器
 * @since 1.0
 **/
public class CustomNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("custom",new CustomBeanDefinitionParse());
    }

}
