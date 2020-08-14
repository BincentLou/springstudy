package com.david.study.spring.msgtag;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version $Id: null.java, v 1.0 2020/8/13 2:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public final class MsgBizCodeRegistry {

    private final static Map<String,String> MSG_BIZ_CODE_MAP = new ConcurrentHashMap<>();

    public static void addMsgBizCode(@NotNull String bizName, @NotNull String bizCode){
        MSG_BIZ_CODE_MAP.put(bizName,bizCode);
    }

    public static List<MsgBizNameCode> getBizCodeList(){

        List<MsgBizNameCode> list = new ArrayList<>();
        MSG_BIZ_CODE_MAP.forEach((key,vl)->{
            list.add(new MsgBizNameCode(key,vl));
        });
        return list;
    };

    public static class MsgBizNameCode{

        private String bizName;

        private String bizCode;

        public MsgBizNameCode(String bizName, String bizCode) {
            this.bizName = bizName;
            this.bizCode = bizCode;
        }

        public String getBizName() {
            return bizName;
        }

        public String getBizCode() {
            return bizCode;
        }

        @Override
        public String toString() {
            return "MsgBizNameCode{" +
                    "bizName='" + bizName + '\'' +
                    ", bizCode='" + bizCode + '\'' +
                    '}';
        }
    }
}
