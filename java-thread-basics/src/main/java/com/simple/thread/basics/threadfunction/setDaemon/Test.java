package com.simple.thread.basics.threadfunction.setDaemon;

/**
 * @Author Simple
 * @Create 2021/8/26 10:43
 */
public class Test {
    public static void main(String[] args) {


        SubDaemonThread daemonThread = new SubDaemonThread();

        /**
         * 设置线程为守护线程
         */
        daemonThread.setDaemon(true);
        daemonThread.start();


        /**
         * main线程
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("main -->: "+i);
        }

    }
}
