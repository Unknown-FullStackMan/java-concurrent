package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:10
 * 使用this锁
 * 同步代码块
 */
public class Test02 {
    private final static int cycleCount = 100;

    public static void main(String[] args) {

        /**
         * 两个对象（不同），两个线程持有不同对象锁，可以并发执行
         * 锁不同，不能实现同步
         */
        final Test02 obj1 = new Test02();
        final Test02 obj2 = new Test02();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this就是obj1对象
                 */
                obj1.print();
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this就是obj2对象
                 */
                obj2.print();
            }
        },"B").start();
    }

    /**
     * 定义线程执行任务，打印100字符串
     */
    public void print(){
        /**
         * 经常使用this当前对象锁作为锁对象
         * 同步代码块
         */
        synchronized (this) {
            for (int i = 0; i < cycleCount; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }
}
