import com.david.study.spring.domain.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @version $Id: null.java, v 1.0 2020/6/26 5:07 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: beanFactory中的createBean方法中，在resolveBeanClass之后，实例化之前，一个机会拦截bean的创建，返回代理对象
 * @since 1.0
 **/
public class BeanInstranitionAwareImpl implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        Assert.isNull(beanClass,"beanClass不能为空");
        if(ObjectUtils.nullSafeEquals(beanClass, SuperUser.class)){
            SuperUser superUser = new SuperUser();
            superUser.setName("一个船新的版本");
            superUser.setAge(22);
            return superUser;
        }
        return null;
    }
}
