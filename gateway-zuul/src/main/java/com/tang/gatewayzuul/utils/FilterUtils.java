package com.tang.gatewayzuul.utils;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Description
 * @Author RLY
 * @Date 2019/6/26 15:47
 * @Version 1.0
 **/
@Component
public class FilterUtils {

    public static final String ZUUL_PRE_TYPE = "pre";
    public static final String ZUUL_POST_TYPE = "post";
    public static final String ZUUL_ROUTE_TYPE = "route";

    public static final String CORRELATION_ID = "correlation_id";

    Logger logger = LoggerFactory.getLogger(FilterUtils.class);

    public boolean isCorrelationId() {
        RequestContext requestContext = RequestContext.getCurrentContext();

        String correlation_id = requestContext.getRequest().getHeader(FilterUtils.CORRELATION_ID);
        String zuul_correlation_id = requestContext.getZuulRequestHeaders().get(FilterUtils.CORRELATION_ID);

        if (StringUtils.isEmpty(correlation_id) && StringUtils.isEmpty(zuul_correlation_id)) {
            return false;
        }

        return true;
    }

    public String getCorrelationId() {
        RequestContext requestContext = RequestContext.getCurrentContext();

        String correlation_id = requestContext.getRequest().getHeader(FilterUtils.CORRELATION_ID);
        String zuul_correlation_id = requestContext.getZuulRequestHeaders().get(FilterUtils.CORRELATION_ID);

        if (!StringUtils.isEmpty(correlation_id)) {
            return correlation_id;
        }

        return zuul_correlation_id;
    }

    public String getServiceId(){
        RequestContext ctx = RequestContext.getCurrentContext();

        //We might not have a service id if we are using a static, non-eureka route.
        if (ctx.get("serviceId")==null) return "";
        return ctx.get("serviceId").toString();
    }
}
