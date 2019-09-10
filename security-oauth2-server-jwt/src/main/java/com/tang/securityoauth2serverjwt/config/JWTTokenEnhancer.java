package com.tang.securityoauth2serverjwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description jwt令牌增强类自定义字段
 * @Author RLY
 * @Date 2019/7/2 9:28
 * @Version 1.0
 **/
//@Configuration
public class JWTTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken accessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        // 此处可以写入获取需放入自定义的属性
        Map<String, Object> additionMap = new HashMap<>();

        // 获取登录用户名 oAuth2Authentication.getName()
        // 获取登录对象 oAuth2Authentication.getUserAuthentication().getPrincipal()
        additionMap.put("customFiled", oAuth2Authentication.getName());
        accessToken.setAdditionalInformation(additionMap);

        //accessToken.getAdditionalInformation().put("customFiled", oAuth2Authentication.getName());
        return oAuth2AccessToken;
    }
}
