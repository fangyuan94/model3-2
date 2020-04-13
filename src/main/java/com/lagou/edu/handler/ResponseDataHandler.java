package com.lagou.edu.handler;

import com.lagou.edu.annotation.JsonRs;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 拦截@ResponseBody请求
 */
@RestControllerAdvice
public class ResponseDataHandler implements ResponseBodyAdvice {

    /**
     * 哪些接口被拦截
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return Optional.ofNullable(methodParameter.getMethod().getAnnotation(JsonRs.class)).isPresent();
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //返回结果封装
        Map<String,Object> rs = new HashMap<>();
        rs.put("success",true);
        rs.put("data",o);
        return rs;
    }
}
