package com.tang.gatewayzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tang.gatewayzuul.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/26 15:56
 * @Version 1.0
 **/
@Component
public class PreFilter extends ZuulFilter {

    @Autowired
    private FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.ZUUL_PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String correlationId = null;
        if (filterUtils.isCorrelationId()) {
            correlationId = filterUtils.getCorrelationId();
        } else {
            correlationId = UUID.randomUUID().toString();
        }

        requestContext.addZuulRequestHeader(FilterUtils.CORRELATION_ID, correlationId);

        return null;
    }
}
