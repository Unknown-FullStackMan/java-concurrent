package com.simple.thread.basics.threadfunction.sleep;

/**
 * @Author Simple
 * @Create 2021/8/25 16:56
 */
public class MyThreadTest04 {
    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04();
        /**
         * main线程和myThread04子线程同时运行，所以beginTime都是相同的，
         * 但是myThread04子线程在运行过程中sleep了2000ms，所以endTime晚2s。
         */
        System.out.println("main beginTime= "+System.currentTimeMillis());
        myThread04.start();
        System.out.println("main endTime= "+System.currentTimeMillis());
    }
}
