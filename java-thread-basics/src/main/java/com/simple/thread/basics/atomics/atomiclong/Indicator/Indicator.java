package com.simple.thread.basics.atomics.atomiclong.Indicator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author Simple
 * @Create 2021/9/2 15:36
 * 使用An自定义计数器
 */
public class Indicator {
    private Indicator() {
    }

    private final static Indicator INDICATOR = new Indicator();

    public static Indicator getInstance() {
        return INDICATOR;
    }

    /**
     * 使用原子类AtomicLong保存请求数，成功数，失败数
     */
    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong successCount = new AtomicLong(0);
    private final AtomicLong failureCount = new AtomicLong(0);

    public void requestCountAdd() {
        requestCount.incrementAndGet();
    }
    public void successCountAdd() {
        successCount.incrementAndGet();
    }
    public void failureCountAdd() {
        failureCount.incrementAndGet();
    }

    public long getRequestCount() {
        return requestCount.get();
    }

    public long getSuccessCount() {
        return successCount.get();
    }

    public long getFailureCount() {
        return failureCount.get();
    }
}
