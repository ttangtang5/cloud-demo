package com.tang.dockercomposeeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DockerComposeEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerComposeEurekaServerApplication.class, args);
    }

}
