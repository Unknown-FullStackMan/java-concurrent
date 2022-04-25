package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 11:26
 * 死锁
 *  同步过程中可能需要使用多个锁，如果获得锁的顺序不一致，可能会导致死锁
 */
public class Test09 {


    public static void main(String[] args) {
        SubThread subThreadA = new SubThread();
        subThreadA.setName("A");
        subThreadA.start();

        SubThread subThreadB = new SubThread();
        subThreadB.setName("B");
        subThreadB.start();
    }

    static class SubThread extends Thread {
        private static final String THREAD_NAME_A = "A";
        private static final String THREAD_NAME_B = "B";
        private static final Object obj1 = new Object();
        private static final Object obj2 = new Object();

        @Override
        public void run() {
            if (THREAD_NAME_A.equals(Thread.currentThread().getName())) {
                synchronized (obj1) {
                    System.out.println("a线程获得obj1锁，还需要获得obj2");
                    synchronized (obj2) {
                        System.out.println("a线程获得obj1锁，又获得obj2");
                        System.out.println("牛逼！！没有发生死锁");
                    }
                }
            }
            if (THREAD_NAME_B.equals(Thread.currentThread().getName())) {
                synchronized (obj2) {
                    System.out.println("a线程获得obj2锁，还需要获得obj1");
                    synchronized (obj1) {
                        System.out.println("a线程获得obj2锁，又获得obj1");
                        System.out.println("牛逼！！没有发生死锁");
                    }
                }
            }
        }
    }
}
