package com.tang.securityoauth2serverjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 9:43
 * @Version 1.0
 **/
@Configuration
public class JwtConfig {

    /**
     * token 的存储方式
     * InMemoryTokenStore 默认方式，保存在本地内存
     * JdbcTokenStore 存储数据库
     * RedisTokenStore 存储Redis，这应该是微服务下比较常用方式
     * JwtTokenStore
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(this.jwtAccessTokenConverter());
    }

    /**
     *JwtAccessTokenConverter是用来生成token的转换器
     * 而token令牌默认是有签名的，且资源服务器需要验证这个签名。
     * 有两种签名：对称、非对称
     * 此处为对称
     * @return
     */
    @Bean
    @Primary
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        //JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        JwtAccessTokenConverter converter = new JWTTokenConvert();
        // jwt令牌签名密钥
        converter.setSigningKey("thisSingleKey");
        return converter;
    }

    @Bean
    public DefaultTokenServices tokenService() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(this.tokenStore());
        defaultTokenServices.setReuseRefreshToken(true);
        return defaultTokenServices;
    }

    /**
     * 注意JwtAccessTokenConverter实现了TokenEnhancer 注入时不注意会报注入错误
     * @return
     */
    //@Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return new JWTTokenEnhancer();
    }
}
