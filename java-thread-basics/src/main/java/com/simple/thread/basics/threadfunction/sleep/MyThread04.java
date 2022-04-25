package com.simple.thread.basics.threadfunction.sleep;

import lombok.SneakyThrows;

/**
 * @Author Simple
 * @Create 2021/8/25 16:54
 */
public class MyThread04 extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("run ,threadName= "+Thread.currentThread().getName()+", beginTime=  "+System.currentTimeMillis());
        /**
         * 子线程沉睡2000ms
         */
        Thread.sleep(2000);
        System.out.println("run ,threadName= "+Thread.currentThread().getName()+", endTime=  "+System.currentTimeMillis());
    }
}
