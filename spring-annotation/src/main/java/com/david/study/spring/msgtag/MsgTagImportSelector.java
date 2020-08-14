package com.david.study.spring.msgtag;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version $Id: MsgTagImportSelector.java.java, v 1.0 2020/8/13 5:29 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class MsgTagImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.david.study.spring.msgtag.MsgTagAnnotationBeanPostProcessor"};
    }
}
