package com.simple.thread.basics.threadcommunicate.waitandnotify;

/**
 * @Author Simple
 * @Create 2021/9/2 17:08
 * notifyAll()唤醒所有等待线程
 * notify()随机唤醒一个线程
 */
public class Test03 {


    private static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
        SunThread sunThread1 = new SunThread();
        SunThread sunThread2 = new SunThread();
        SunThread sunThread3 = new SunThread();
        sunThread1.start();
        sunThread2.start();
        sunThread3.start();

        Thread.sleep(2000);
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }

    static class SunThread extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                System.out.println("wait开始");
                try {
                    LOCK.wait();
                    System.out.println("wait已执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
