package com.simple.thread.basics.threadfunction.yield;

/**
 * @Author Simple
 * @Create 2021/8/26 9:17
 */
public class MyThreadTest06 {


    public static void main(String[] args) {



        new MyThread06().start();

        /**
         * main线程同样执行循环任务
         */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MyThread06.LOOP; i++) {

        }
        long endTime = System.currentTimeMillis();
        System.out.println("main线程执行完任务，花时ms=  "+(endTime-startTime));
    }
}
