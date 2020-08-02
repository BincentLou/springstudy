package com.david.study.spring.convertion;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;

/**
 * @version $Id: null.java, v 1.0 2020/8/2 5:01 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:推荐实现 ConditionalGenericConverter ,优化了GenericConverter/ConditionalConverter
 * @see ConditionalGenericConverter
 * @see GenericConverter
 * @see ConditionalConverter
 * @since 1.0
 **/
public class CutomizedProperties2StringConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor srcTypeDescriptor, TypeDescriptor targetTypeDescriptor) {
        return srcTypeDescriptor.getObjectType().equals(Properties.class)&&targetTypeDescriptor.getObjectType().equals(String.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class,String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Properties properties = (Properties)source;
        StringBuilder sb = new StringBuilder();
       properties.entrySet().forEach(objectObjectEntry -> {sb.append(objectObjectEntry.getValue()).append("=").append(objectObjectEntry.getValue()).append(System.lineSeparator());});
        return sb.toString();
    }


}
