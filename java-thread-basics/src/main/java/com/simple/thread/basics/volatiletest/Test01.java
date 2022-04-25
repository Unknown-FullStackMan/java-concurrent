package com.simple.thread.basics.volatiletest;

/**
 * @Author Simple
 * @Create 2021/9/2 13:31
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        printString.printStringMethod();

        Thread.sleep(1000);
        System.out.println("在main线程中修改打印标志");
        printString.setContinuePrint(false);
        // 程序根本不会停止，因为printString.printStringMethod();方法调用后该方法一直处于死循环状态。程序根本执行不到printString.setContinuePrint(false);
        // 解决方法：使用多线程
    }

    static class PrintString {
        private boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
        }

        public void printStringMethod() {
            while (continuePrint) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
