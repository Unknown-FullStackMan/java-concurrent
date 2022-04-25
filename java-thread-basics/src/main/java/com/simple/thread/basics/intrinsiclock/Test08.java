package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:28
 * 同步过程中出现异常，会自动释放锁
 */
public class Test08 {

    private static final int CYCLE_COUNT = 100;

    public static void main(String[] args) {

        /**
         * 两个对象（不同），两个线程持有不同对象锁，可以并发执行
         * 锁不同，不能实现同步
         */
        final Test08 obj1 = new Test08();

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
                Test08.synchronizedPrint();
            }
        },"B").start();
    }

    /**
     * 定义线程执行任务，打印100字符串
     */
    public void print(){
        /**
         * 使用当前类的运行时类作为锁对象，可以简单理解为把Test06类的字节码文件作为锁对象
         * 同步代码块
         */
        synchronized (Test08.class) {
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
                if (i == 50 ){
                    // 模拟在线程获取锁之后出现异常
                    int a = i/0;
                }
            }
        }
    }

    /**
     * 定义线程执行任务，打印100字符串
     * 使用synchronized修饰静态方法，默认运行时类作为锁对象,Test06类的字节码文件作为锁对象
     * 同步静态方法
     */
    public synchronized static void synchronizedPrint(){
            for (int i = 0; i < CYCLE_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
    }
}
