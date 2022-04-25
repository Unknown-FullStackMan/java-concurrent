package com.simple.thread.basics.threadfunction.interrupt;

/**
 * @Author Simple
 * @Create 2021/8/26 10:43
 */
public class Test2 {
    public static void main(String[] args) {
        SubThread2 subThread2 = new SubThread2();
        subThread2.start();

        /**
         * main线程
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("main -->: "+i);
        }

        /**
         * 中断子线程
         * 仅仅是给子线程标记中断，但子线程并没有真正的中断
         */
        subThread2.interrupt();
    }
}
