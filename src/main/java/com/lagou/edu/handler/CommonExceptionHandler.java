package com.lagou.edu.handler;

import com.lagou.edu.exception.LoginException;
import com.lagou.edu.exception.NoAutherException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理公共异常处理机制
 * @author fangyuan
 */
@RestControllerAdvice
public class CommonExceptionHandler {


    /**
     * 处理自定义异常 返回指定信息
     * @param re
     * @return
     */
    @ExceptionHandler({LoginException.class,NoAutherException.class})
    public Map<String,Object> handleNoAutherException(final Exception re) {
        re.printStackTrace();
        Map<String,Object> rs = new HashMap<>();
        rs.put("success",false);
        rs.put("errorMessage",re.getMessage());
        return rs;
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(final Exception re) {

        re.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage",re.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
