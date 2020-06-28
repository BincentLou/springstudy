import com.david.study.spring.domain.SuperUser;
import com.david.study.spring.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: beanFactory中的createBean方法中，在resolveBeanClass之后，实例化之前，一个机会拦截bean的创建，返回代理对象
 * @since 1.0
 **/
public class BeanInstantiaitionAwareImpl implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        Assert.isNull(beanClass,"beanClass不能为空");
        if(ObjectUtils.nullSafeEquals(beanClass, SuperUser.class)){
            SuperUser superUser = new SuperUser();
            superUser.setName("一个船新的版本");
            superUser.setAge(22);
            return superUser;
        }
        //默认什么都不做，返回null，继续下一步实例化
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(User.class)){
            User user = (User) bean;
            user.setName("至尊宝");
            user.setAge(589);
            return false;
        }
        //默认返回true，什么也不做，继续下一步 初始化
        return true;
    }
}