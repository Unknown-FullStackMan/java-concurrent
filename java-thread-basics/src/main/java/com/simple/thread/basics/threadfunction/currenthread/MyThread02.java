package com.simple.thread.basics.threadfunction.currenthread;

/**
 * @Author Simple
 * @Create 2021/8/25 16:04
 */
public class MyThread02 extends Thread{

    public MyThread02(String name) {
        super(name);
        System.out.println("构造方法----当前线程 Thread.currentThread().getName() ： "+Thread.currentThread().getName());
        System.out.println("构造方法----当前线程 this.getName() ： "+this.getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法----当前线程 Thread.currentThread().getName() ： "+Thread.currentThread().getName());
        System.out.println("run()方法----当前线程 this.getName() ： "+this.getName());
    }
}
