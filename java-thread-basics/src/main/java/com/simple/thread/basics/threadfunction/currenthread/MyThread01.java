package com.simple.thread.basics.threadfunction.currenthread;

/**
 * @Author Simple
 * @Create 2021/8/24 15:28
 */
public class MyThread01 extends Thread{

    public MyThread01(String name) {
        super(name);
        System.out.println("构造方法----当前线程： "+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法----当前线程： "+Thread.currentThread().getName());
    }
}
