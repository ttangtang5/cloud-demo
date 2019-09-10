package com.tang.securityoauth2resourcejwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/15 14:56
 * @Version 1.0
 **/
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/protected/**")
                .hasRole("user")
                .anyRequest()
                .authenticated();
    }
}
