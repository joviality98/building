package com.building.Interceptors;

import com.building.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//token拦截器
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        Map<String, Object> map = new HashMap<>();
        //获取请求头中的token
        String token = request.getHeader( "Authorization");
        try {
            if(token != null){
                JwtUtil.verify(token);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","token无效");
        }
        map.put("state",false);//设置状态
        //将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;chartset=UTF-8");
        response.getWriter().println(json);

        return false;
    }

}
