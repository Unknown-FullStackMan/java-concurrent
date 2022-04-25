package com.simple.thread.basics.threadsafe.Atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Simple
 * @Create 2021/8/26 14:15
 */
public class NumSafe {

    /**
     * 在Java中提供了一个线程安全的AtomicInteger类，保证了操作的原子性
     */
    AtomicInteger num = new AtomicInteger();

    public int getNumSafe() {

        return num.getAndIncrement();
    }
}
