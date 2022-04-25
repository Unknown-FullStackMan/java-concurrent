package com.simple.thread.basics.threadfunction.setPriority;

/**
 * @Author Simple
 * @Create 2021/8/25 16:29
 */
public class MyThreadTest07 {
    public static void main(String[] args) {

        MyThread07 myThread0A = new MyThread07("myThread0A");
        myThread0A.setPriority(1);
        myThread0A.start();


        MyThread07 myThread0B = new MyThread07("myThread0B");
        myThread0B.setPriority(10);
        myThread0B.start();
    }
}
