package com.david.study.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @version $Id: null.java, v 1.0 2020/7/21 3:45 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:ResourceLoader 测试用例
 * @since 1.0
 **/
public class ResourceLoaderStudyDemo {

    public static void main(String[] args) throws IOException {
        //DefaultResourceLoader 用例
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        defaultResourceLoader(resourceLoader);
        classPathResourceLoader(resourceLoader);
        //FileSystemResourceLoader 用例
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        fileSystemResourceLoader(fileSystemResourceLoader);
    }

    private static void fileSystemResourceLoader(DefaultResourceLoader resourceLoader) throws IOException {
        resourceLoader(resourceLoader,getCurrentJavaLocation());
    }
    private static void classPathResourceLoader(DefaultResourceLoader resourceLoader) throws IOException {
        resourceLoader(resourceLoader,"classpath:/META-INF/application.yaml");
    }

    private static void defaultResourceLoader(DefaultResourceLoader resourceLoader) throws IOException {
        resourceLoader(resourceLoader,"META-INF/application.properties");
    }
    private static void resourceLoader(ResourceLoader resourceLoader,String location) throws IOException {
        Resource resource = resourceLoader.getResource("/"+location);
        printResource(resource);
    }

    private static void printResource(Resource resource) throws IOException {
        EncodedResource encodedResource = new EncodedResource(resource);
        Reader reader = encodedResource.getReader();
        System.out.println(IOUtils.toString(reader));
    }

    static String getUserDirLocation(){
        return System.getProperty("user.dir");
    }
    static String getCurrentJavaLocation(){
        return getUserDirLocation()+"/springstudy/spring-resource/src/main/java/com/david/study/spring/resource/ResourceLoaderStudyDemo.java";
    }
}
