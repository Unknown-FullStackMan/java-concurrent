package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:28
 * 同步实例方法
 * 使用synchronized修饰实例方法
 * 对象锁
 */
public class Test04 {
    private static final int CYCLE_COUNT = 100;
    public static final Object OBJECT = new Object();

    public static void main(String[] args) {

        /**
         * 两个对象（不同），两个线程持有不同对象锁，可以并发执行
         * 锁不同，不能实现同步
         */
        final Test04 obj1 = new Test04();

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
                 * 使用的锁对象this就是obj1对象
                 */
                obj1.synchronizedPrint();
//                /**
//                 * 使用的锁对象this就是new Test04()对象
//                 */
//                new Test04().synchronizedPrint();
            }
        },"B").start();
    }

    /**
     * 定义线程执行任务，打印100字符串
     */
    public void print(){
        /**
         * 使用常量作为锁对象
         * 同步代码块
         */
        synchronized (this) {
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }

    /**
     * 定义线程执行任务，打印100字符串
     * 使用synchronized修饰实例方法，默认this作为锁对象
     * 同步实例方法
     */
    public synchronized void synchronizedPrint(){
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
    }
}
