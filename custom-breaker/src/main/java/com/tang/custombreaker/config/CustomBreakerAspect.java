package com.tang.custombreaker.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 17:25
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class CustomBreakerAspect {

    private static final Integer THRESHOLD = 3;

    private Map<String, AtomicInteger> failCounter = new HashMap();

    private Map<String, AtomicInteger> breakerCounter = new HashMap<>();

    @Around("execution(* com.tang..*(..))")
    public Object breaker(ProceedingJoinPoint pjp) throws Throwable {
        String signature = pjp.getSignature().toLongString();
        Object proceed = null;
        log.info("signature : {}" + signature);

        if (failCounter.containsKey(signature)) {
            // 失败超过界限 开始进入断路
            if (failCounter.get(signature).get() > THRESHOLD && breakerCounter.get(signature).get() < THRESHOLD) {
                failCounter.get(signature).set(0);
                breakerCounter.get(signature).incrementAndGet();

                return "网络连接超时，请重试。";
            }
        } else {
            failCounter.put(signature, new AtomicInteger(0));
            breakerCounter.put(signature, new AtomicInteger(0));
        }

        try {
            proceed = pjp.proceed();
            failCounter.get(signature).set(0);
            breakerCounter.get(signature).set(0);
        } catch (Throwable throwable) {
            log.warn("Circuit breaker counter: {}, Throwable {}",
                    failCounter.get(signature).incrementAndGet(), throwable.getMessage());
            breakerCounter.get(signature).set(0);
            throw throwable;
        }

        return proceed;
    }
}
