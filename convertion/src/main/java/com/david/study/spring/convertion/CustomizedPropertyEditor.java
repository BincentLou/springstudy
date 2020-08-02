package com.david.study.spring.convertion;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @version $Id: null.java, v 1.0 2020/7/31 10:59 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class CustomizedPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Object, Object> e :properties.entrySet()) {
            stringBuilder.append(e.getKey()).append("=").append(e.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(text));
            setValue(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
