package com.gao.controller;

import com.gao.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HellController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "helllo";
    }

    @RequestMapping("/goLogin")
    public String goLogin(LoginForm form) {
        System.out.println (form);
        return "success";
    }

    @RequestMapping("/register")
    public String register(Map<String, Object> dtos) {
        return "register";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> dtos) {
        dtos.put ("name", "<h1>小明</h1>");
        dtos.put ("age", "12");
        dtos.put ("sex", "男");
        dtos.put ("price", 20.5);
        dtos.put ("users", Arrays.asList ("zhangsan", "lisi", "wangwu", "zhaoliu"));
        return "success";
    }
}
