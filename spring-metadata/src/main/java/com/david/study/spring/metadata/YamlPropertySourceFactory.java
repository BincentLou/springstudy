package com.david.study.spring.metadata;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @version $Id: null.java, v 1.0 2020/7/19 12:53 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:注解解析器 指定解析 yaml文件的处理器
 * @since 1.0
 **/

public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {

        // snakeYaml 自带的yaml文件解析器
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(encodedResource.getResource());
        Properties properties = yamlPropertiesFactoryBean.getObject();

        return new PropertiesPropertySource(name,properties);
    }
}
