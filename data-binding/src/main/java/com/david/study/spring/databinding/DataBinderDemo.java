package com.david.study.spring.databinding;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/7/30 11:13 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DataBinderDemo {
    public static void main(String[] args) {
        DataBinder dataBinder = new DataBinder(new User(),"user");
//        dataBinder.

        Map<String,String> propertiesMap = new HashMap<>();
        propertiesMap.put("name","娄文斌");
        propertiesMap.put("age","30");
        propertiesMap.put("company.name","Apache founding");
        
        PropertyValues pvs = new MutablePropertyValues(propertiesMap);
        dataBinder.bind(pvs);
        BindingResult bindResult = dataBinder.getBindingResult();
        System.out.println(bindResult);
        System.out.println(dataBinder.getTarget());
    }

    static class User{

        private String name;

        private Integer age;

        private Company company;

        public Company getCompany() {
            return company;
        }

        public User setCompany(Company company) {
            this.company = company;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public User setAge(Integer age) {
            this.age = age;
            return this;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", company=" + company +
                    '}';
        }
    }

    static class Company{

        private String name;

        private String address;

        public String getName() {
            return name;
        }

        public Company setName(String name) {
            this.name = name;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Company setAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
