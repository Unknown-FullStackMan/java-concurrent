package com.simple.thread.basics.threadcommunicate.producerandconsumer.stackop;

import com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop.ValueOp;

/**
 * @Author Simple
 * @Create 2021/9/3 9:57
 * 多个生产者  多个消费者
 */
public class Test01 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        Consumer consumer1 = new Consumer(stack,"消费者1号");
        Consumer consumer2 = new Consumer(stack,"消费者2号");
        Consumer consumer3 = new Consumer(stack,"消费者3号");
        Producer producer1 = new Producer(stack,"生产者1号");
        Producer producer2 = new Producer(stack,"生产者2号");
        Producer producer3 = new Producer(stack,"生产者3号");
        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();

    }
}
