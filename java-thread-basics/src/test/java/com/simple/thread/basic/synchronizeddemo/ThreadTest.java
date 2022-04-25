//package com.simple.thread.basic.synchronizeddemo;
//
//import com.simple.thread.basics.synchronizeddemo.MyRunnable2;
//import com.simple.thread.basics.threadandrunnable.runnable.MyRunnable;
//import com.simple.thread.basics.threadandrunnable.thread.MyThread;
//import org.junit.Test;
//
///**
// * @Author Simple
// * @Create 2021/8/24 15:33
// */
//public class ThreadTest {
//
//    @Test
//    public void testMyRunnable() throws InterruptedException {
//        MyRunnable2 myRunnable = new MyRunnable2();
//        Thread thread1 = new Thread(myRunnable,"线程01");
//        Thread thread2 = new Thread(myRunnable,"线程02");
//        Thread thread3 = new Thread(myRunnable,"线程03");
//        Thread thread4 = new Thread(myRunnable,"线程04");
//        Thread thread5 = new Thread(myRunnable,"线程05");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//
//    }
//}
