package com.simple.thread.basics.threadfunction.getstate;

import static com.simple.thread.basics.threadfunction.yield.MyThread06.LOOP;

/**
 * @Author Simple
 * @Create 2021/8/26 10:42
 */
public class SubThread extends Thread{


    /**
     * 线程的生命周期时线程对象的生老病死，即线程的状态
     * 线程的生命周期可以通过getState()方法获得,线程状态是Thread.State枚举定义的，有以下几种：
     * NEW 新建状态。创建线程对象，在调用start（）启动之间的状态
     *
     * RUNNABLE 可运行状态。是个复合状态，包含：READY和RUNNING两个状态。
     *              READY是start（）方法执行后。
     *              READY是该线程可以被调度器进行调度使他处于RUNNING状态
     *              Thread.yield()方法可以把线程从RUNNING转到READY状态
     *
     * BLOCKED 阻塞状态。线程发起阻塞的I/O操作，或者申请由其他线程独占的资源，线程会转换为BLOCKED 阻塞状态，不会占用cpu资源。当阻塞I/O操作执行完
     * 或者线程获得了其申请的资源，线程可以转换为RUNNABLE。
     *
     * WAITING 等待状态。线程执行了Object.wait()，Thread.join()方法会把线程转换为WAITING状态，执行Object.notify()方法，或者加入的线程执行完毕，当前线程会转换为RUNNABLE
     *
     * TIMED_WAITING 与WAITING类型，等待状态。不会无限等待，如果线程没有在指定的时间范围内完成期望的操作，该线程会转换为RUNNABLE
     *
     * TERMINATED 终止状态，线程结束
     *
     */
    @Override
    public void run() {

    }
}
