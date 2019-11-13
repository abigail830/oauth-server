package com.github.abigail830.oauthserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
@Slf4j
public class MD5PasswordEncoder implements PasswordEncoder {

    //对密码进行加密
    @Override
    public String encode(CharSequence charSequence) {
        log.debug(charSequence.toString());
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    //对密码进行判断匹配
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String encode = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
        boolean res = s.equals(encode);
        return res;
    }

}
