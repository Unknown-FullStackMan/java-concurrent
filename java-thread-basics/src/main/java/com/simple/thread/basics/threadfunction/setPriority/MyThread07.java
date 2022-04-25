package com.simple.thread.basics.threadfunction.setPriority;

import static com.simple.thread.basics.threadfunction.yield.MyThread06.LOOP;

/**
 * @Author Simple
 * @Create 2021/8/25 16:27
 */
public class MyThread07 extends Thread{

    public MyThread07(String name) {
        super(name);
    }

    int count ;

    /**
     * 设置线程优先级，java线程的优先级范围是1——10，如果超出这个范围会抛出异常：illegalArgumentException
     * 在操作系统中，优先级越高，获得cpu的资源的可能性越大
     * 线程优先级本质上是给线程调度器一个提示信息，以便给调度器决定调度哪些线程，注意不能保证优先级高的线程先运行。
     * Java优先级设置不当或者滥用可能会导致某些线程会永远得不到调度，造成线程饥饿。
     * 一般情况下，使用普通优先级即可，不需要设置优先级。
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP; i++) {
            for (int j = 0; j < 11111; j++) {
                count++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"子线程执行完任务，花时ms=  "+(endTime-startTime));
    }
}
