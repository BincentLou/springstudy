package com.david.study.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2020/7/21 4:00 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ResourceStudyDemo {

    public static void main(String[] args) throws IOException {
        String dirLocation = getJavaFile();
        String fileLocation = "/springstudy/spring-resource/src/main/java/com/david/study/spring/resource/ResourceStudyDemo.java";
        File file = new File(dirLocation+fileLocation);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource);
        System.out.println(IOUtils.toString(encodedResource.getReader()));
    }

    static String getJavaFile(){
        return System.getProperty("user.dir");
    }
}
