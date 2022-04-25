package com.simple.thread.basics.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Simple
 * @Create 2021/9/2 14:04
 * 使用原子类自增
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new SubThread().start();
        }
        Thread.sleep(1000);
        System.out.println(SubThread.count.get());
    }

    static class SubThread extends Thread {
        // 创建AtomicInteger原子类对象
        private static AtomicInteger count = new AtomicInteger();
        /**
         * 这段代码运行后不是线程安全的，想要线程安全需要使用synchronized关键字进行同步，如果使用了synchronized，那么就没有必要时有volatile了
         */
        public static void addCount() {
            for (int i = 0; i < 1000; i++) {
                count.getAndIncrement();
            }
            System.out.println(Thread.currentThread().getName()+"  count= "+count.get());
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
