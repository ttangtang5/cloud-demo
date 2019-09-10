package com.tang.securityoauth2serverjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityOauth2ServerJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2ServerJwtApplication.class, args);
    }

}
