package com.simple.thread.basics.atomics.atomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author Simple
 * @Create 2021/9/2 15:54
 * 原子数组
 */
public class Test {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.get(1));

        atomicIntegerArray.set(0,1);
        atomicIntegerArray.set(1,2);

        System.out.println(atomicIntegerArray);

        // 修改数组元素的值，把数组元素加上某个值
        atomicIntegerArray.addAndGet(2,3);

        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.getAndAdd(3, 4));
        System.out.println(atomicIntegerArray);


        // CAS操作
        System.out.println(atomicIntegerArray.compareAndSet(4,0,5));
        System.out.println(atomicIntegerArray);
    }
}
