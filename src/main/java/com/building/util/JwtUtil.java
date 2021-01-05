package com.building.util;

import com.building.common.exception.MyException;
import com.building.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * jwt工具类
 */
public class JwtUtil {

    //秘钥
    public static String jwt_secret = "yanzhen@cms@cc956183393.";
    //过期时长——1天
    public static long jwt_expr = 3600*24*1000;

    //1.生成token
    public static String sign(User user){

        //1.指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //2.生成签发时间
        long newMillis = System.currentTimeMillis();
        Date date = new Date(newMillis);

        //3.创建playload的私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getUserId());
        claims.put("userName",user.getUserName());
        //4.生成签发人
        String subject = user.getUserName();

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(date)
                .setSubject(subject)
                .signWith(signatureAlgorithm,jwt_secret);

        //5.设置过期时间
        Date exprDate = new Date(newMillis+jwt_expr);
        builder.setExpiration(exprDate);

        return builder.compact();

    }

    //2.验证token
    public Claims verify(String token){
        try {
            if(StringUtils.isEmpty(token)){
                return null;
            }
            return Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //3.获取用户信息
    public User getUser(String token){
        try {
            if(StringUtils.isEmpty(token)){
                throw  new MyException("token不能为空");
            }
            if(!verify(token).isEmpty()){
                Claims claims = verify(token);
                User user = new User();
                user.setUserId(claims.get("id")+"");
                user.setUserName(claims.get("userName")+"");
                return user;
            }else{
                throw new MyException("超时或不合法token");
            }
        } catch (Exception e) {
            throw  new MyException("超时或不合法token");
        }
    }


}
