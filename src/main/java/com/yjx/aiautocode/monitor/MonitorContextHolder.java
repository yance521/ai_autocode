package com.yjx.aiautocode.monitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonitorContextHolder {

    /**
     * 创建线程本地变量ThreadLocal，用于存储监控上下文
     */
    private static final ThreadLocal<MonitorContext> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置监控上下文
     */
    public static void setContext(MonitorContext context) {
        CONTEXT_HOLDER.set(context);
    }

    /**
     * 获取当前监控上下文
     */
    public static MonitorContext getContext() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除监控上下文
     */
    public static void clearContext() {
        CONTEXT_HOLDER.remove();
    }
}
