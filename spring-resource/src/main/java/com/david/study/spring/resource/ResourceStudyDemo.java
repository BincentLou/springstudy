package com.david.study.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2020/7/21 4:00 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:   resource用例
 * @see org.springframework.core.io.Resource
 * @see org.springframework.core.io.ClassPathResource
 * @see FileSystemResource
 * @since 1.0
 **/
public class ResourceStudyDemo {

    public static void main(String[] args) throws IOException {

        // FileSystemResource demo
//        fileSystemResourceDemo();

        // ClassPathResource demo
        classPathResourceDemo();
    }

    private static void classPathResourceDemo() throws IOException {
        String fileLocation = "META-INF/application.yaml";
        ClassPathResource classPathResource = new ClassPathResource(fileLocation);
        EncodedResource encodedResource = new EncodedResource(classPathResource);
        IOUtils.toString(encodedResource.getReader());
    }

    private static void fileSystemResourceDemo() throws IOException {
        String fileLocation = getFileLocation("/springstudy/spring-resource/src/main/java/com/david/study/spring/resource/ResourceStudyDemo.java");
        File file = new File(fileLocation);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource);
        System.out.println(IOUtils.toString(encodedResource.getReader()));
    }

    static String getUserDir(){
        return System.getProperty("user.dir");
    }

    static String getFileLocation(String fileReference){
        return getUserDir()+fileReference;
    }
}
