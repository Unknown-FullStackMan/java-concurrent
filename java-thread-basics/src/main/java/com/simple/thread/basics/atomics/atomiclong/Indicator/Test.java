package com.simple.thread.basics.atomics.atomiclong.Indicator;

import java.util.Random;

/**
 * @Author Simple
 * @Create 2021/9/2 15:43
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                // 每个线程就是一个请求，请求总数+1
                Indicator.getInstance().requestCountAdd();
                int num = new Random().nextInt();
                if (num % 2 ==0 ) {
                    Indicator.getInstance().successCountAdd();
                } else {
                    Indicator.getInstance().failureCountAdd();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Indicator.getInstance().getRequestCount());
        System.out.println(Indicator.getInstance().getSuccessCount());
        System.out.println(Indicator.getInstance().getFailureCount());
    }
}
