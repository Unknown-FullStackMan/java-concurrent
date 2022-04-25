package com.simple.thread.basics.synchronizedpractice.cycleprintnum;

/**
 * @Author Simple
 * @Create 2021/8/24 17:23
 */
public class MyRunnable2 implements Runnable{

    private int i = 100;

     public void run() {
        while (true) {
            synchronized(this){
                if (i <= 0) {
                    Thread.interrupted();
                } else {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("当前线程： " + Thread.currentThread().getName() + " 当前i值= " + i);
                        i--;
                    }
                    try {
                        this.notifyAll();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
