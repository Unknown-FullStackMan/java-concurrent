package com.simple.thread.basics.threadfunction.getid;

/**
 * @Author Simple
 * @Create 2021/8/26 9:16
 */
public class MyThread05 extends Thread{

    /**
     * 某个编号的线程运行结束后，改编号可能会被后续创建的线程使用
     */

    @Override
    public void run() {
        System.out.println("run方法----当前线程Name ： "+Thread.currentThread().getName());
        System.out.println("run方法----当前线程Id ： "+Thread.currentThread().getId());
    }
}
