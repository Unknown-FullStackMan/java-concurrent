package com.simple.javathreaddemo.runnable;

/**
 * @author Simple
 * @date 2021/3/11 15:06
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            System.out.println("多线程被执行了");
        }
    }
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("每天都在学习java");
        }
    }
}