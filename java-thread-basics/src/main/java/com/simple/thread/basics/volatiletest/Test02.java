package com.simple.thread.basics.volatiletest;

/**
 * @Author Simple
 * @Create 2021/9/2 13:31
 * volatile保障变量在线程间可见
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        final PrintString printString = new PrintString();

        new Thread(new Runnable() {
            public void run() {
                printString.printStringMethod();
            }
        },"SubThread").start();
        Thread.sleep(1000);
        System.out.println("在main线程中修改打印标志");
        printString.setContinuePrint(false);
        /**
         * 程序运行后，可能会出现死循环
         * 原因：main线程修改continuePrint=false后，子线程可能读取不到
         * 解决方法：使用volatile关键字修饰continuePrint字段
         *         volatile作用：可以强制线程从公共内存中读取变量的值，而不是从工作内存中读取
         */
    }

    static class PrintString {
        private volatile boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
        }

        public void printStringMethod() {
            System.out.println(Thread.currentThread().getName()+"开始....");
            while (continuePrint) {

            }
            System.out.println(Thread.currentThread().getName()+"结束....");
        }
    }
}
