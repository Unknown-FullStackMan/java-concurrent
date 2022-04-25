package com.simple.thread.basics.threadfunction.getid;

/**
 * @Author Simple
 * @Create 2021/8/26 9:17
 */
public class MyThreadTest05 {

    private static final Integer threadCounts = 10;
    public static void main(String[] args) {

        System.out.println("main线程id= "+Thread.currentThread().getId());

        for (int i = 0; i < threadCounts; i++) {
            new MyThread05().start();
        }
    }
}
