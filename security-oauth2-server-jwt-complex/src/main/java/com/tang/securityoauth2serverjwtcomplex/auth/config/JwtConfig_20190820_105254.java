package com.tang.securityoauth2serverjwtcomplex.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/3 10:53
 * @Version 1.0
 **/
@Configuration
public class JwtConfig {

    @Bean
    public TokenStore tokenStore() {
        // 生产建议new RedisTokenStore()
        return new JwtTokenStore(this.jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtTokenConverter();
        tokenConverter.setSigningKey("thisSingleKey");
        return tokenConverter;
    }
}
