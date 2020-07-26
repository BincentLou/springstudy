package com.david.study.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/7/23 7:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class PathPatternResovlerDemo {

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        String propertiesPath = "/springstudy/spring-resource/src/main/resources/META-INF/*.properties";
        String filePath = "/"+dir+propertiesPath;

        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver(fileSystemResourceLoader);
        pathMatchingResourcePatternResolver.setPathMatcher(new PropertiePathMatcher());
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(filePath);
        for (Resource resource:resources){
            System.out.println(IOUtils.toString(new EncodedResource(resource).getReader()));
        }
    }

    static class PropertiePathMatcher implements PathMatcher{

        @Override
        public boolean isPattern(String path) {
            return path.endsWith("properties");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith("properties");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }
}
