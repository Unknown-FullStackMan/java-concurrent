package com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop;

/**
 * @Author Simple
 * @Create 2021/9/3 9:57
 * 多个生产者  多个消费者
 */
public class Test02 {
    public static void main(String[] args) {
        ValueOp valueOp = new ValueOp();

        Consumer consumer1 = new Consumer(valueOp);
        Consumer consumer2 = new Consumer(valueOp);
        Consumer consumer3 = new Consumer(valueOp);
        Producer producer1 = new Producer(valueOp);
        Producer producer2 = new Producer(valueOp);
        Producer producer3 = new Producer(valueOp);
        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();

        // 使用if进行雕件判断，会出现条件发生了改变但是线程没有监控到，使用使用while要再次判断条件是否成立，才能进行操作。
        // 使用notify()可能会造成假死现象（生产者唤醒生产者/消费者唤醒消费者），使用notifyAll()唤醒所有等待线程。
    }
}
