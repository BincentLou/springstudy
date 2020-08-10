package com.david.study.spring.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version $Id: null.java, v 1.0 2020/8/10 2:47 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 自定义ImportSelector,规定哪一个Configuration应该被加载
 * @see ImportSelector
 * @since 1.0
 **/
public class ExpartImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.david.study.spring.enable.ExPartConfiguration"};
    }

}
