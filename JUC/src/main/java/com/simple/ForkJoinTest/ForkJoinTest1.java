package com.simple.ForkJoinTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


/**
 * @author Simple
 * @date 2021/3/19 9:37
 */

public class ForkJoinTest1 {
    private static final long SUM = 20_0000_0000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
        test3();
    }

    /*
     * 使用普通方法
     *
     * */

    public static void test1(){
        long star = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < SUM; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(" 使用普通方法:时间：" + (end-star));
        System.out.println("---------------");
    }

    /*
     *
     * 使用 ForkJoin 方法
     * */
    public static void test2() throws ExecutionException, InterruptedException {
        long star = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,SUM);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);

        Long along = submit.get();

        System.out.println(along);
        long end = System.currentTimeMillis();
        System.out.println("使用 ForkJoin 方法:时间：" + (end - star));
        System.out.println("---------------");
    }

    /*
     * 使用流计算
     * */
    public static void test3(){
        long star = System.currentTimeMillis();
        long sum = LongStream.range(0L,20_0000_0000L).parallel().reduce(0,Long::sum);
//        int usm = IntStream.range(1,1000000).parallel().reduce(0,Integer::sum);
        System.out.println(sum);
//        System.out.println(usm);
        long end = System.currentTimeMillis();
        System.out.println("使用流计算:时间：" + (end - star));
        System.out.println("-------------");
    }


}


