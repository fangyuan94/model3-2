package com.lagou.edu.intercepts;

import com.lagou.edu.exception.LoginException;
import com.lagou.edu.exception.NoAutherException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * 权限校验
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private  final Pattern pattern =   Pattern.compile("/user/login");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前是否为登陆接口
        String url = request.getRequestURI();

        if(url.contains(".css") || url.contains(".js")){
            return true;
        }

        if(!pattern.matcher(url).find()){

            //非登陆请求，判断当前session中是否有用户信息
            Object userInfo = request.getSession().getAttribute("userInfo");
            if(userInfo == null){
                //非法登陆 跳到重新登陆界面
                throw new NoAutherException("权限失败重新登陆");
            }
            //设置存活时间 默认60s 每次操作重新刷新时间
            request.getSession().setMaxInactiveInterval(60*3);
        }

        return true;
    }
}
