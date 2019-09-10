package com.tang.securityoauth2resourcesa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description 设置权限粒度
 * @Author RLY
 * @Date 2019/6/28 15:00
 * @Version 1.0
 **/
@Configuration
public class WebResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/protected/**")
                .hasRole("admin")
                .anyRequest()
                .authenticated();

    }

}
