package com.building.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 用户密码的加密解密
 */
@Component
public class BCryptPasswordEncoderUtil extends BCryptPasswordEncoder {

    //加密
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    //将输入的密码加密和数据库中的密码比对
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return super.matches(rawPassword,encodedPassword);
    }

}
