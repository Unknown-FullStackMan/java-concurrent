package com.simple.thread.basics.threadcommunicate.producerandconsumer.stackop;

import com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop.ValueOp;

/**
 * @Author Simple
 * @Create 2021/9/3 9:53
 * 生产者线程
 */
public class Producer extends Thread{
    /**
     * 调用ValueOp类的setValue（）方法来产生值
     */
    private MyStack stack;

    public Producer(MyStack stack,String name) {
        super(name);
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            stack.push();
        }
    }
}
