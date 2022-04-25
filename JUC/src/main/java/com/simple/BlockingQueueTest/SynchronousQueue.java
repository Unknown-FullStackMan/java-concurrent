package com.simple.BlockingQueueTest;

/**
 * @author Simple
 * @date 2021/3/18 17:46
 */

/**
 * 同步队列没有容量，也可以视为容量为 1 的队列；
 *
 * 进去一个元素，必须等待取出来之后，才能再往里面放入一个元素；
 *
 * put 方法和 take 方法；
 *
 * Synchronized 和 其他的BlockingQueue 不一样 它不存储元素；
 *
 * put了一个元素，就必须从里面先take出来，否则不能再put进去值！
 */

public class SynchronousQueue {
    public static void main(String[] args) {
        java.util.concurrent.SynchronousQueue<String> synchronousQueue = new java.util.concurrent.SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 01");
                synchronousQueue.put("01");
                System.out.println(Thread.currentThread().getName()+"put 02");
                synchronousQueue.put("02");
                System.out.println(Thread.currentThread().getName()+"put 03");
                synchronousQueue.put("03");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"take"+synchronousQueue.take());
                System.out.println(Thread.currentThread().getName()+"take"+synchronousQueue.take());
                System.out.println(Thread.currentThread().getName()+"take"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


