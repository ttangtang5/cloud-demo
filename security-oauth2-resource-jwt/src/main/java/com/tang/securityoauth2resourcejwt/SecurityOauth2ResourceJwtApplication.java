package com.tang.securityoauth2resourcejwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SecurityOauth2ResourceJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2ResourceJwtApplication.class, args);
    }

}
