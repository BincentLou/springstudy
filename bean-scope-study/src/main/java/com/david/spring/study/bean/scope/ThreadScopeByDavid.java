package com.david.spring.study.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/6/18 8:28 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$ david 自定义bean的 scope
 * @since 1.0
 **/
public class ThreadScopeByDavid implements Scope {

    public static final String THREAD_SCOPE = "DAVID-Thread-scope";

    private NamedThreadLocal<Map<String,Object>> threadLocal = new NamedThreadLocal("david"){
        @Override
        protected Map<String,Object> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Object result = getStringObjectMap().get(name);
        if(result == null){
            result = objectFactory.getObject();
            getStringObjectMap().put(name,result);
        }
        return result;
    }

    @NonNull
    private Map<String, Object> getStringObjectMap() {
        return threadLocal.get();
    }

    @Override
    public Object remove(String name) {
        return getStringObjectMap().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
            //TODO
    }

    @Override
    public Object resolveContextualObject(String key) {
        return getStringObjectMap().get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
