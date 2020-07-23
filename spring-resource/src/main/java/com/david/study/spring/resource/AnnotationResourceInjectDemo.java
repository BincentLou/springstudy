package com.david.study.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2020/7/21 5:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class AnnotationResourceInjectDemo implements ResourceLoaderAware {

    @Value("classpath:META-INF/application.yaml")
    public Resource yamResource;

    @Value("classpath*:/META-INF/*.properties")
    public Resource[] resources;

    @Value("${user.dir}")
    private String currentPath;

    private ResourceLoader resourceLoader;

    @Autowired
    ResourceLoader resourceLoaderInject;

    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void init() throws IOException {
        EncodedResource encodedResource = new EncodedResource(yamResource,"UTF-8");
        System.out.println("======================");
        System.out.println(IOUtils.toString(encodedResource.getReader()));
        System.out.println("======================");
        System.out.println(currentPath);
        System.out.println("======================");

        for (Resource resource:resources){
            System.out.println(IOUtils.toString(new EncodedResource(resource).getReader()));
        }

        System.out.println(resourceLoader == resourceLoaderInject);
        System.out.println(applicationContext == resourceLoaderInject);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationResourceInjectDemo.class);

        applicationContext.refresh();


        applicationContext.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
