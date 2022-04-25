package com.simple.thread.basics.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Simple
 * @Create 2021/9/2 15:11
 * 测试自带的cas操作
 */
public class AtomicIntegerCasTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

//        boolean compareAndSet(int expect, int update)
//        期望值、更新值
//        如果实际值 和 我期望值相同，那么就更新
//        如果实际制 和 我期望值不同，那么就不更新
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());

//        因为期望值是 2020 ，实际值却变成了2021 所以会修改失败
//        CAS 是 CPU 的并发原语
        atomicInteger.getAndIncrement();//++操作
        System.out.println(atomicInteger.compareAndSet(2022,2021));
        System.out.println(atomicInteger.get());
    }
}
