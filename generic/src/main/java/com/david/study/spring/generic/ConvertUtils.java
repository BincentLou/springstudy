package com.david.study.spring.generic;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @version $Id: null.java, v 1.0 2020/8/20 2:10 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ConvertUtils {

    public static <K,V> Map<K,List<V>> convertToMap(List<V> list, Function<V, K> function){

        Map<K,List<V>> map = new HashMap();
        for(V item:list){
            List<V> sbList = map.get(function.apply(item));
            if(CollectionUtils.isEmpty(sbList)){
                sbList = new ArrayList<>();
            }
            sbList.add(item);
        }
        return map;
    }

    public static void main(String[] args) {
        Map<Long,Long> map = Collections.emptyMap();
        map.get(1L);
        int a = 1;
        System.out.println("ss");
    }
}
