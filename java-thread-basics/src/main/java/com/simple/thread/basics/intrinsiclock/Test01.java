package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 9:47
 * 使用this锁
 * 同步代码块
 */
public class Test01 {

    private final static int cycleCount = 100;

    public static void main(String[] args) {


        /**
         * 同步代码块：锁同一个对象--对象锁
         * 不能并发执行，必须先获得对象锁
         *
         *
         * 创建Test01对象，通过对象名调用print()方法
         * 创建两个线程，分别都调用print()方法
         */
        final Test01 obj = new Test01();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this就是obj对象
                 */
                obj.print();
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                /**
                 * 使用的锁对象this也是obj对象
                 */
                obj.print();
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
            for (int i = 0; i <= cycleCount; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }

    /**
     * 说明：
     * 1）假设Thread-0线程获得CPU执行权，调用obj对象的对象的print()方法，执行方法体，先获得this对象--obj的锁执行for循环
     * 2）假设Thread-0在for循环执行期间Thread-1获得了CPU执行权，调用obj对象的print()方法，执行方法体。要先获得this对象obj锁
     * 但是现在obj锁被Thread-0线程持有，还未被释放。所以Thread-1进入等待区等待获取this对象obj锁。
     * 3)Thread-0线程获得CPU执行权，执行完方法，释放了obj锁。
     * 4)等待区的Thread-1线程获得obj锁，执行print()方法。
     */
}
