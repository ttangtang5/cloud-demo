package com.tang.securityoauth2serverjwt.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 11:03
 * @Version 1.0
 **/
@Component
public class JWTTokenConvert extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);

        // 设置用户信息authentication.getPrincipal()

        // 将用户信息添加到token额外信息中
        defaultOAuth2AccessToken.getAdditionalInformation().put("customFiled", "use convert implement enhancer");

        return super.enhance(defaultOAuth2AccessToken, authentication);
    }
}
