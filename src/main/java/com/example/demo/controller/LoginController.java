package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping(value = "/user/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session)
    {
        if(!StringUtils.isEmpty(username)&&password.equals("123456"))
        {
            session.setAttribute("user",username);
            return "redirect:/main.html";
        }
        else
        {
            map.put("msg","登陆失败");
            return "index";
        }
    }
}
