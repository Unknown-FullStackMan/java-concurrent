package com.simple.Auxiliaryclass;

import java.util.concurrent.CountDownLatch;

/**
 * @author Simple
 * @date 2021/3/17 17:49
 */



public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"==>Go Out");
                countDownLatch.countDown(); //每个线程都数量-1
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();// 等待计数器归零，然后向下执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("close door");
    }
}


