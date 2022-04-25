package com.simple.thread.basics.threadfunction.currenthread;



/**
 * @Author Simple
 * @Create 2021/8/25 16:05
 */
public class MyThreadTest02 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 创建子线程，在main线程中调用MyThread01的构造方法，所以在构造方法中的当前的线程是main
         * 但是this就是创建（new）出来的myThread02对象
         */
        MyThread02 myThread02 = new MyThread02("myThread02");


        /**
         * 启动子线程，会调用run方法，所以在run方法中输出的是子线程名称：myThread01
         * this也是子线程对象名称
         */
        myThread02.start();

        Thread.sleep(500);
        System.out.println("\n\n");

        /**
         * 创建子线程，Thread的MyThread02父类，所以不会调用构造方法。
         * 创建出来的新线程，执行run方法，所以Thread.currentThread() == 新的线程名称
         * this还是指代传入的Runnable target，target == myThread02，看源码，target ！= null，就这执行的 target的run方法，所以
         * this == target == myThread02
         */
        Thread thread = new Thread(myThread02);
        thread.start();

    }
}
