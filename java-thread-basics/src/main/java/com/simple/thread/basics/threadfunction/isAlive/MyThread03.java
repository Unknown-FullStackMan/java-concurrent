package com.simple.thread.basics.threadfunction.isAlive;

/**
 * @Author Simple
 * @Create 2021/8/25 16:27
 */
public class MyThread03 extends Thread{

    @Override
    public void run() {
        System.out.println("run() isAlive: "+this.isAlive());
    }
}
