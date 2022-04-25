package com.simple.thread.basics.volatiletest;

/**
 * @Author Simple
 * @Create 2021/9/2 14:04
 *  volatile不具备原子性
 */
public class Test03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SubThread().start();
        }
    }

    static class SubThread extends Thread {
        // volatile关键字仅仅是表示所有线程从主内存读取count变量的值
        public volatile static int count;

        /**
         * 这段代码运行后不是线程安全的，想要线程安全需要使用synchronized关键字进行同步，如果使用了synchronized，那么就没有必要时有volatile了
         */
        public static void addCount() {
            for (int i = 0; i < 1000; i++) {
                /**
                 * count++不是原子操作
                 */
                count++;
            }
            System.out.println(Thread.currentThread().getName()+"  count= "+count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
