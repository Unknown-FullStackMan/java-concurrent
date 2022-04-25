package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:18
 * 使用常量作为锁对象
 * 同一个常量锁，与调用对象无关，与是否为静态方法
 * 可以实现同步
 */
public class Test03 {

    private static final int CYCLE_COUNT = 100;
    public static final Object OBJECT = new Object();

    public static void main(String[] args) {

        /**
         * 两个对象（不同），两个线程持有不同对象锁，可以并发执行
         * 锁不同，不能实现同步
         */
        final Test03 obj1 = new Test03();
        final Test03 obj2 = new Test03();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this就是OBJECT对象
                 */
                obj1.print();
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this也是OBJECT对象
                 */
                obj2.print();
            }
        },"B").start();


        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this也是OBJECT对象
                 */
                staticPrint();
            }
        },"C").start();
    }

    /**
     * 定义线程执行任务，打印100字符串
     */
    public void print(){
        /**
         * 使用常量作为锁对象
         * 同步代码块
         */
        synchronized (OBJECT) {
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }

    /**
     * 定义线程执行任务，打印100字符串
     */
    public static void staticPrint(){
        /**
         * 使用常量作为锁对象
         * 同步代码块
         */
        synchronized (OBJECT) {
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }
}
