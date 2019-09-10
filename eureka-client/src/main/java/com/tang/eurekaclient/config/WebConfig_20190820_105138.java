package com.tang.eurekaclient.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.tang.eurekaclient.controller.PerformanceInteceptor;
import com.tang.eurekaclient.interceptors.ClientInterceptor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/24 14:15
 * @Version 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PerformanceInteceptor())
                .addPathPatterns("/coffee/**").addPathPatterns("/order/**");
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> {
            builder.indentOutput(true);
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        };
    }


    @Bean
    @LoadBalanced
    public RestTemplate setRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if (interceptors == null) {
            restTemplate.setInterceptors(Collections.singletonList(new ClientInterceptor()));
        } else {
            interceptors.add(new ClientInterceptor());
            restTemplate.setInterceptors(interceptors);
        }

      return restTemplate;
    }

}
