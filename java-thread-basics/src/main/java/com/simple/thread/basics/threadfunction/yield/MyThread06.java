package com.simple.thread.basics.threadfunction.yield;

/**
 * @Author Simple
 * @Create 2021/8/26 9:16
 */
public class MyThread06 extends Thread{

    public static final Integer LOOP = 10000;

    /**
     *      暂停当前正在执行的线程对象（及放弃当前拥有的cup资源），
     *      并执行其他线程。yield()做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其
     *      他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
     *      但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
     */

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP; i++) {
            Thread.yield();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("子线程执行完任务，花时ms=  "+(endTime-startTime));
    }
}
