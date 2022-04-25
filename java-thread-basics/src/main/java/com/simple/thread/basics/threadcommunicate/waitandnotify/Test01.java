package com.simple.thread.basics.threadcommunicate.waitandnotify;

/**
 * @Author Simple
 * @Create 2021/9/2 17:02
 */
public class Test01 {
    public static void main(String[] args) {
        String text = "txt";
        String text2 = "txt2";
        System.out.println("同步前");
        new Thread(()->{
            synchronized (text) {
                System.out.println("同步开始");
                try {
                    text.wait();
//                text2.wait(); 不是锁调用会报错illegalMonitorStateException异常
                    System.out.println("wait后执行情况");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                text.notify();
            }
        }).start();


        System.out.println("同步结束");
    }
}
