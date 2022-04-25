package com.simple.thread.basics.synchronizedpractice.cycleprintnum;

/**
 * @Author Simple
 * @Create 2021/8/24 19:31
 */
public class Test {
    public static void main(String[] args) {
        MyRunnable2 myRunnable = new MyRunnable2();
        Thread thread1 = new Thread(myRunnable,"线程01");
        Thread thread2 = new Thread(myRunnable,"线程02");
        Thread thread3 = new Thread(myRunnable,"线程03");
        Thread thread4 = new Thread(myRunnable,"线程04");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();



    }
}
