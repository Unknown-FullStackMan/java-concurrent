package com.simple.thread.basics.threadfunction.interrupt;

import static com.simple.thread.basics.threadfunction.yield.MyThread06.LOOP;

/**
 * @Author Simple
 * @Create 2021/8/26 10:42
 */
public class SubThread2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < LOOP; i++) {
            /**
             * 每次循环的时候。判断一下线程中断标志
             * isInterrupted()返回线程的中断标志
             */
            if (this.isInterrupted()) {
                System.out.println("子线程中断标志为true，线程退出");
                /**
                 * 中断循环，run()方法执行完毕，子线程运行完毕，也可以使用break;
                 */
                return;
            }
            System.out.println("子线程i--> "+i);
        }
    }
}
