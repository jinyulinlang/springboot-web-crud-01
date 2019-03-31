package com.gao.controller;

import com.gao.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    //    @RequestMapping(value = "/user/login")
    @RequestMapping("/user/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Map<String, Object> bean, HttpSession session) {
        if (!StringUtils.isEmpty (name) && "123456".equals (password)) {
            return "redirect:/main.html";
        } else {
            session.setAttribute ("msg", "用户名或者密码错误!");
            return "redirect:/";
        }
    }

}
