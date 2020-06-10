package com.david.spring.study.bean.scope.web;

import com.david.study.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version $Id: null.java, v 1.0 2020/6/5 5:11 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Controller
public class IndexController {

    @Autowired
    private User user;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("user",user);
        return "index";
    }
}
