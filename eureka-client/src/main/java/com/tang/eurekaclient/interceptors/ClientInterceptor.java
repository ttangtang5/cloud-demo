package com.tang.eurekaclient.interceptors;

import com.tang.eurekaclient.filters.UserContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @Description restTemplate 拦截器，处理请求首部
 * @Author RLY
 * @Date 2019/6/27 9:07
 * @Version 1.0
 **/
public class ClientInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpHeaders headers = httpRequest.getHeaders();

        headers.set(UserContextHolder.CORRELATION_ID, UserContextHolder.getUserContext().getCorrelationId());
        headers.set(UserContextHolder.TOKEN, UserContextHolder.getUserContext().getToken());

        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
