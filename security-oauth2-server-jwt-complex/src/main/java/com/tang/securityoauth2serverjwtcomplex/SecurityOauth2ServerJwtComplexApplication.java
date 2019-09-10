package com.tang.securityoauth2serverjwtcomplex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityOauth2ServerJwtComplexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2ServerJwtComplexApplication.class, args);
    }

}
