package com.simple.thread.basics.threadlocal;

/**
 * @Author Simple
 * @Create 2021/9/3 11:26
 * ThreadLocal的基本使用
 */
public class Test01 {

    /**
     * 定义对象
     */
    static ThreadLocal threadLocal = new ThreadLocal();

    static class SubThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                // 设置线程相关的值
                threadLocal.set(Thread.currentThread().getName()+" - " + i);
                // 调用get()方法读取关联的值
                System.out.println(Thread.currentThread().getName() + " value= " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        SubThread subThread1 = new SubThread();
        SubThread subThread2 = new SubThread();
        subThread1.start();
        subThread2.start();
    }
}
