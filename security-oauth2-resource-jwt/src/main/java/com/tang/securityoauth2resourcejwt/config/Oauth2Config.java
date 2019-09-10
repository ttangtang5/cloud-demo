package com.tang.securityoauth2resourcejwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/15 11:15
 * @Version 1.0
 **/
//@Configuration
public class Oauth2Config {

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(this.jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("thisSingleKey");
        return jwtAccessTokenConverter;
    }
}
