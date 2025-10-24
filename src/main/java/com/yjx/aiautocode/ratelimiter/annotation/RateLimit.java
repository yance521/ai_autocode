package com.yjx.aiautocode.ratelimiter.annotation;

import com.yjx.aiautocode.ratelimiter.enums.RateLimitType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//作用于方法
@Retention(RetentionPolicy.RUNTIME)//运行时
public @interface RateLimit {
    
    /**
     * 限流key前缀
     */
    String key() default "";//成员变量  允许为成员变量指定默认值（通过 default关键字）
    
    /**
     * 每个时间窗口允许的请求数
     */
    int rate() default 10;
    
    /**
     * 时间窗口（秒）
     */
    int rateInterval() default 1;
    
    /**
     * 限流类型
     */
    RateLimitType limitType() default RateLimitType.USER;
    
    /**
     * 限流提示信息
     */
    String message() default "请求过于频繁，请稍后再试";
}
