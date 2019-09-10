package com.tang.eurekaclient.filters;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/26 17:05
 * @Version 1.0
 **/
public class UserContext {

    private String correlationId;

    private String token;

    public String getCorrelationId() {
        return correlationId;
    }

    public UserContext setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserContext setToken(String token) {
        this.token = token;
        return this;
    }
}
