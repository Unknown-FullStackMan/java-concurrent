package com.simple.Futuretest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * @author Simple
 * @date 2021/3/19 9:56
 *
 * 没有返回值的runAsync异步回调
 */


public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        发起一个请求
        System.out.println(System.currentTimeMillis());
        System.out.println("-----------");

        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
//            发起一个异步任务
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"......");
        });

        System.out.println(System.currentTimeMillis());
        System.out.println("-------------------------");
        System.out.println(future.get());//获取执行结果
    }
}

