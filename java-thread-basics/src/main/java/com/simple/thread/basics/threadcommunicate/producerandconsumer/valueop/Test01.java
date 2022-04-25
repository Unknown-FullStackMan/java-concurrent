package com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop;

/**
 * @Author Simple
 * @Create 2021/9/3 9:57
 * 一个生产者一个消费者
 */
public class Test01 {
    public static void main(String[] args) {
        ValueOp valueOp = new ValueOp();

        Consumer consumer = new Consumer(valueOp);
        Producer producer = new Producer(valueOp);
        consumer.start();
        producer.start();

        // 生产者和消费者交替进行
    }
}
