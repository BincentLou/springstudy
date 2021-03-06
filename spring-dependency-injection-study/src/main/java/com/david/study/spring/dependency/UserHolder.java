package com.david.study.spring.dependency;
import com.david.study.spring.dependency.date.CityEnum;
import com.david.study.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/5/15 9:23 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class UserHolder {

//    @Resource // 注入的是User
//    @Autowired //注入的是SuperUser
    private User user;

    private CityEnum cityEnum;

    private CityEnum[] workCities;

    private List<CityEnum> lifeCities;

    private Map<Integer,CityEnum> bornCities;

    public Map<Integer, CityEnum> getBornCities() {
        return bornCities;
    }

    public UserHolder setBornCities(Map<Integer, CityEnum> bornCities) {
        this.bornCities = bornCities;
        return this;
    }

    public CityEnum[] getWorkCities() {
        return workCities;
    }

    public List<CityEnum> getLifeCities() {
        return lifeCities;
    }

    public UserHolder setLifeCities(List<CityEnum> lifeCities) {
        this.lifeCities = lifeCities;
        return this;
    }

    public UserHolder setWorkCities(CityEnum[] workCities) {
        this.workCities = workCities;
        return this;
    }

    private Resource configFile;


    public Resource getConfigFile() {
        return configFile;
    }

    public UserHolder setConfigFile(Resource configFile) {
        this.configFile = configFile;
        return this;
    }

    public CityEnum getCityEnum() {
        return cityEnum;
    }

    public UserHolder setCityEnum(CityEnum cityEnum) {
        this.cityEnum = cityEnum;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserHolder setUser(User user) {
        this.user = user;
        return this;
    }

    public UserHolder(User user, CityEnum cityEnum) {
        this.user = user;
        this.cityEnum = cityEnum;
    }

//    public UserHolder() {
//    }


    public UserHolder() {
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "bornCities=" + bornCities +
                '}';
    }
}
