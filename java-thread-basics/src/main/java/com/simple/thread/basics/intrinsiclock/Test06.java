package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:48
 * 同步方法与同步代码块如何选择：
 * 同步方法：并发效率低，锁的粒度粗
 * 同步代码块：并发效率高，锁的粒度细
 */
public class Test06 {
    private static final int CYCLE_COUNT = 100;
    public static void main(String[] args) {
        final Test06 test06 = new Test06();

        new Thread(new Runnable() {
            public void run() {
                test06.synchronizedDoLongTimeTask();
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                test06.synchronizedDoLongTimeTask();
            }
        },"B").start();
    }

    /**
     * 两个线程执行完doLongTimeTask，同步代码块，
     * 花费时间：大致为3s+两个线程的for循环时间
     * 并发效率高，锁的粒度细
     */
    public void doLongTimeTask(){
        try {
            System.out.println("Prepare do task");
            Thread.sleep(3000);

            synchronized (this) {
                System.out.println("Task Begin,Sync data");
                for (int i = 0; i < CYCLE_COUNT; i++) {
                    System.out.println(Thread.currentThread().getName()+" ---> "+i);
                }
            }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 两个线程执行完synchronizedDoLongTimeTask，同步方法，
     * 花费时间：大致为3s+3s+两个线程的for循环时间
     * 并发效率底，锁的粒度粗
     */
    public synchronized void synchronizedDoLongTimeTask(){
        try {
            System.out.println("Prepare do task");
            Thread.sleep(3000);

                System.out.println("Task Begin,Sync data");
                for (int i = 0; i < CYCLE_COUNT; i++) {
                    System.out.println(Thread.currentThread().getName() + " ---> " + i);
                }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
