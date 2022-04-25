package com.simple.thread.basics.threadfunction.join;

/**
 * @Author Simple
 * @Create 2021/8/26 13:24
 */
public class JoinTest2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin t1 = new ThreadJoin("ThreadA");
        ThreadJoin t2 = new ThreadJoin("ThreadB");
        t1.start();
        /**
         * join方法可以传递参数，join(10)表示main线程会等待t1线程10毫秒，10毫秒过去后，
         * main线程和t1线程之间执行顺序由串行执行变为普通的并行执行
         *
         * 程序执行前面1毫秒内打印的都是ThreadA线程，1毫秒后，ThreadA和ThreadB程序交替打印。
         *
         * 所以，join方法中如果传入参数，则表示这样的意思：如果A线程中掉用B线程的join(10)，
         * 则表示A线程会等待B线程执行10毫秒，10毫秒过后，A、B线程并行执行。需要注意的是，
         * jdk规定，join(0)的意思不是A线程等待B线程0秒，而是A线程等待B线程无限时间，直到B线程执行完毕，即join(0)等价于join()。
         */
        t1.join(1);
        t2.start();
    }
}
