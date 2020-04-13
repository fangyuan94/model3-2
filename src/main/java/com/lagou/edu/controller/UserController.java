package com.lagou.edu.controller;

import com.lagou.edu.annotation.JsonRs;
import com.lagou.edu.exception.LoginException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private final static String userName_dataBase = "admin";

    private final static String password_dataBase = "admin";

    @GetMapping(value = "/login")
    @JsonRs
    public void login(String userName, String password, HttpServletRequest request)  {
        //登陆请求 验证用户名密码
        if(!userName_dataBase.equals(userName)){
            throw new LoginException("用户名不存在");
        }
        if(!password_dataBase.equals(password)){
            throw new LoginException("密码不正确");
        }

        request.getSession().setAttribute("userInfo",userName);
        request.getSession().setMaxInactiveInterval(60*3);
    }
}
