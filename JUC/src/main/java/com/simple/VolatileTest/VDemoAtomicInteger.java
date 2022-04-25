package com.simple.VolatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Simple
 * @date 2021/3/19 13:16
 */
public class VDemoAtomicInteger {
    //    private static volatile int number = 0;
    private static volatile AtomicInteger number = new AtomicInteger();
    public static void add(){
//        number++;
//        ++ 不是一个原子操作，是2~3个操作
        number.incrementAndGet();//底层是 CAS 保证原子性
    }

    public static void main(String[] args) {
//        理论上 number === 20000

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    add();
                }
            }).start();
        }
        while(Thread.activeCount()>2){
//            main gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+",num + "+number);
    }

}
