package com.david.study.spring.validation;

import com.david.study.spring.metadata.SelfBean;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2020/7/26 10:26 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:spring validator 示例 ，需要针对不同的对象实现不同的validator对象，非常不容易扩展
 *
 * @see Validator
 * @see Errors
 * @since 1.0
 **/
public class SpringValidatorDemo {

    public static void main(String[] args) {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("id不能为空", Locale.getDefault(),"SelfBean 的 id不能为空");
        SelfBeanValidator selfBeanValidator = new SelfBeanValidator();
        SelfBean selfBean = new SelfBean();
        selfBean.setName("娄文斌");
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(selfBean,"selfBean");
        selfBeanValidator.validate(selfBean,result);
        result.getFieldErrors().forEach(fieldError-> System.out.println(messageSource.getMessage(fieldError.getCode(),new Object[0],Locale.getDefault())));
    }


}

class SelfBeanValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SelfBean.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"id","id不能为空");
    }
}
