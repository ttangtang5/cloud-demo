package com.tang.gatewayzuul.utils;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/27 10:07
 * @Version 1.0
 **/
public class AbTestingRoute {

    String serviceName;
    String active;
    String endpoint;
    Integer weight;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
