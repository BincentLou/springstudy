package com.david.study.spring.messagesource;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * @version $Id: null.java, v 1.0 2020/7/25 11:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class CustomizReloadableMessageSource implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    private Properties reloadableProperties;

    private Resource resource;

    public Properties getReloadableProperties() {
        return reloadableProperties;
    }

    static final String relativefilePath = "messages.properties";

    private Executor executor ;

    public CustomizReloadableMessageSource() throws IOException {
        this.resourceLoader = getResourceLoader();
        this.executor = Executors.newSingleThreadExecutor();
        resource = getResource(relativefilePath);
        reloadableProperties = new Properties();
        reloadableProperties.load(new InputStreamReader(resource.getInputStream()));
        watchFileEvent();
    }

    private void watchFileEvent() {
        executor.execute(()->{
            File file = null;
            try {
                file = resource.getFile();
                Path filePath = file.toPath();
                Path parentPath = filePath.getParent();
                FileSystem fileSystem = FileSystems.getDefault();
                WatchService watchService = fileSystem.newWatchService();
                parentPath.register(watchService, ENTRY_MODIFY);
                while (true){
                    WatchKey watchKey = watchService.take();
                    try {
                        if(watchKey.isValid()){
                            for(WatchEvent watchEvent : watchKey.pollEvents()){
                                Watchable watchable =  watchKey.watchable();
                                Path dirPath = (Path) watchable;
                                System.out.println(dirPath);
                                Path relativeFilePath = (Path) watchEvent.context();
                                if(relativeFilePath.getFileName().endsWith(relativefilePath)){
                                    filePath = dirPath.resolve(relativeFilePath);
                                    reloadProperties(filePath);
                                    System.out.println(reloadableProperties);
                                }
                            }
                        }
                    }finally {
                        watchKey.reset();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }catch (InterruptedException ee){

            }

        });
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader !=null?resourceLoader:new DefaultResourceLoader();
    }

    Resource getResource(String path){
        ResourceLoader resourceLoader1 =  getResourceLoader();
        return resourceLoader1.getResource(path);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader ;
    }

    private void reloadProperties(Path filePath) throws IOException {
        File file = filePath.toFile();
        if(file.exists()){
            reloadableProperties.load(new FileReader(file));
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        CustomizReloadableMessageSource messageSource = new CustomizReloadableMessageSource();
        for(int i = 0;i<100;i++){
            System.out.println(messageSource.getReloadableProperties());
            Thread.sleep(1000);
        }
    }
}
