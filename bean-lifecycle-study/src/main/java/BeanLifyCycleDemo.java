import com.david.study.spring.domain.SuperUser;
import com.david.study.spring.domain.User;
import com.david.study.spring.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:bean的生命周期，beanDefinition->实例化-》初始化demo
 * @since 1.0
 **/
public class BeanLifyCycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");
        beanFactory.addBeanPostProcessor(new BeanInstantiaitionAwareImpl());
        User user =  (User)beanFactory.getBean("user");
        User superUser =  (SuperUser)beanFactory.getBean("superUser");
        UserHolder userHolder =  (UserHolder)beanFactory.getBean("userHolder");
        System.out.println(user);
        System.out.println(superUser);
        System.out.println(userHolder);
    }
}
