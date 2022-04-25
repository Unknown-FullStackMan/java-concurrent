package com.simple.thread.basics.threadcommunicate.waitandnotify;

/**
 * @Author Simple
 * @Create 2021/9/2 17:08
 */
public class Test02 {


    private static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    System.out.println("开始");
                    try {
                        LOCK.wait();
                        System.out.println("wait结束");
                    } catch (InterruptedException e) {
                        System.out.println("wait等待被中断");
                    }

                }
            }
        });
        thread.start();

        Thread.sleep(2000);

        thread.interrupt();

    }

}
