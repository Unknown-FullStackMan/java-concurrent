package com.simple.thread.basics.threadcreate;

/**
 * @Author Simple
 * @Create 2021/8/24 15:32
 */
public class MyRunnable01 implements Runnable{

    public void run() {
        System.out.println("当前线程： "+Thread.currentThread().getName());
        System.out.println("MyRunnable implements Runnable: Override run() function");
    }
}
