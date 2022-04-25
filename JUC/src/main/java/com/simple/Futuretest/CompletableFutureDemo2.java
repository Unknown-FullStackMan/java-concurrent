package com.simple.Futuretest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/19 10:00
 * 返回值的异步回调supplyAsync
 * whenComplete: 有两个参数，一个是t 一个是u
 * T：是代表的 正常返回的结果；
 * U：是代表的 抛出异常的错误信息；
 * 如果发生了异常，get可以获取到exceptionally返回的值；
 */
public class CompletableFutureDemo2  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
//            success 回调
            System.out.println("t=>" + t);//正常的返回结果
            System.out.println("u=>" + u);//抛出异常的错误信息
        }).exceptionally((e) -> {
//            error 回调
            System.out.println(e.getMessage());
            return 404;
        }).get());

    }

}
