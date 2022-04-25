package com.simple.thread.basics.threadfunction.join;

/**
 * @Author Simple
 * @Create 2021/8/26 13:12
 */
public class ThreadJoin extends Thread{

    public ThreadJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+":  "+i);
        }
    }
}
