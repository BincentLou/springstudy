package com.david.spring.study.source;

import com.david.spring.study.source.domain.ExtensionObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version $Id: AddExtensionObjectDemo.class, v 1.0 2020/5/26 6:35 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: BeanFactory.registerResolveDependency(ExtensionObject.class);选择外挂在容器之内
 * 只能用到依赖注入，不能用到依赖查找，且不能当成正常的bean来处理生命周期；也不能实现接口回调
 * @since 1.0
 **/
public class AddExtensionObjectDemo {

    @Autowired
    private ExtensionObject extensionObject;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AddExtensionObjectDemo.class);
        applicationContext.addBeanFactoryPostProcessor(
                new BeanFactoryPostProcessor() {
                    @Override
                    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                        beanFactory.registerResolvableDependency(ExtensionObject.class,new ExtensionObject());
                    }
                }
        );
        applicationContext.refresh();

        AddExtensionObjectDemo demo = applicationContext.getBean(AddExtensionObjectDemo.class);
        System.out.println(demo.extensionObject);
        System.out.println(applicationContext.getBean(ExtensionObject.class));
        applicationContext.close();
    }
}
