package com.simple.ExecutorServicetest;

/**
 * @author Simple
 * @date 2021/3/18 17:53
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo01 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

//        线程池用完必须要关闭线程池
        try {
            for (int i = 0; i < 100; i++) {
                //            通过线程池创建线程
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool3.shutdown();
        }
    }
}

