package com.simple.thread.basics.threadfunction.currenthread;


/**
 * @Author Simple
 * @Create 2021/8/24 15:30
 */
public class MyThreadTest01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("在main方法中打印当前线程: "+Thread.currentThread().getName());

        /**
         * 创建子线程，在main线程中调用MyThread01的构造方法，所以在构造方法中的当前的线程是main
         */
        MyThread01 myThread01 = new MyThread01("myThread01");

        /**
         * 在main方法中直接调用run()方法，没有开启子线程，还是在main线程中执行的，所以输出的是线程名称：main
         */
        myThread01.run();

        /**
         * 启动子线程，会调用run方法，所以在run方法中输出的是子线程名称：myThread01
         */
        myThread01.start();


    }
}
