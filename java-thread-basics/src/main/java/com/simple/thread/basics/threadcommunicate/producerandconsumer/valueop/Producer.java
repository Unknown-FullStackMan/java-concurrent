package com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop;

/**
 * @Author Simple
 * @Create 2021/9/3 9:53
 * 生产者线程
 */
public class Producer extends Thread{
    /**
     * 调用ValueOp类的setValue（）方法来产生值
     */
    private ValueOp valueOp;

    public Producer(ValueOp valueOp) {
        this.valueOp = valueOp;
    }

    @Override
    public void run() {
        while (true) {
            valueOp.setValue();
        }
    }
}
