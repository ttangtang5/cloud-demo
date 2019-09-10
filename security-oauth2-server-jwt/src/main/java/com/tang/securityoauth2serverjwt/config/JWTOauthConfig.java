package com.tang.securityoauth2serverjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 10:02
 * @Version 1.0
 **/
@Configuration
public class JWTOauthConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    //@Autowired
    //private JWTTokenEnhancer tokenEnhancer;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     *  配置AuthorizationServer 端点的非安全属性，
     *  也就是 token 存储方式、token 配置、用户授权模式等。
     *  默认不需做任何配置，除非使用 密码授权方式, 这时候必须配置 AuthenticationManager
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        // tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer, jwtAccessTokenConverter));

        endpoints.tokenStore(tokenStore)
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(jwtAccessTokenConverter);
    }

    /**
     * 配置 ClientDetailsService 独立client客户端的信息。
     * 包括权限范围、授权方式、客户端权限等配置。
     * 授权方式有4种:implicit, client_redentials, password , authorization_code,
     * 其中密码授权方式必须结合 AuthenticationManager 进行配置。必须至少配置一个客户端。
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用JdbcClientDetailsService客户端详情服务
        //clients.withClientDetails(new JdbcClientDetailsService(dataSource));
        clients.inMemory()
                .withClient("service_a")
                .secret("{noop}thisSecret")
                .scopes("service")
                .authorizedGrantTypes("password", "refresh_token");
    }
}
