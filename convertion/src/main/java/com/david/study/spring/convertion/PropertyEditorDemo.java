package com.david.study.spring.convertion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @version $Id: null.java, v 1.0 2020/7/31 10:30 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @see PropertyEditor
 * @see PropertyEditorSupport
 * @since 1.0
 **/
public class PropertyEditorDemo {

    public static void main(String[] args) {
        CustomizedPropertyEditor propertyEditor = new CustomizedPropertyEditor();
        propertyEditor.setAsText("name = 娄文斌");
        System.out.println(propertyEditor.getAsText());

    }
}
