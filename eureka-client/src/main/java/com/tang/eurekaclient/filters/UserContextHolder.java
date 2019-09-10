package com.tang.eurekaclient.filters;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/26 17:06
 * @Version 1.0
 **/
public class UserContextHolder {
    // 注意请求结果remove
    private static ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static final String CORRELATION_ID = "correlation_id";

    public static final String TOKEN = "token";

    public static UserContext getUserContext(){
        UserContext context = threadLocal.get();

        if (context == null) {
            context = new UserContext();
            threadLocal.set(context);
        }

        return context;
    }

    public static void setUserContext(UserContext userContext){
        threadLocal.set(userContext);
    }

    public static void setCorrelationId(String correlationId) {
        UserContext userContext = threadLocal.get();
        userContext.setCorrelationId(correlationId);
    }

    public static void setToken(String token) {
        UserContext userContext = threadLocal.get();
        userContext.setToken(token);
    }

    public static void remove(){
        System.out.println("threadLocal 被移除");
        threadLocal.remove();
    }
}
