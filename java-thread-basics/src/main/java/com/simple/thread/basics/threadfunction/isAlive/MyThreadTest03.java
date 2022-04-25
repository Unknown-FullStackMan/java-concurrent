package com.simple.thread.basics.threadfunction.isAlive;

/**
 * @Author Simple
 * @Create 2021/8/25 16:29
 */
public class MyThreadTest03 {
    public static void main(String[] args) {

        MyThread03 myThread03 = new MyThread03();

        /**
         * 启动之前一定为false
         */
        System.out.println("begin myThread03 isAlive : "+myThread03.isAlive());

        myThread03.start();

        /**
         * isAlive状态不确定。如果main线程执行到这语句而myThread03还没有结束就返回true;反之，返回false
         */
        System.out.println("end myThread03 isAlive : "+myThread03.isAlive());
    }
}
