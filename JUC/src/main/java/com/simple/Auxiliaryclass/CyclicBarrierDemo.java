package com.simple.Auxiliaryclass;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Simple
 * @date 2021/3/17 18:04
 */


public class CyclicBarrierDemo {
    public static void main(String[] args) {
//        主线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
//                子线程
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+finalI+"颗龙珠");
                try {
                    cyclicBarrier.await();//加法计数等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}

