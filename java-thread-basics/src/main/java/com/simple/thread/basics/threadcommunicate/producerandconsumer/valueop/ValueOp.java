package com.simple.thread.basics.threadcommunicate.producerandconsumer.valueop;

/**
 * @Author Simple
 * @Create 2021/9/3 9:46
 *
 * 生产者消费者：操作值
 */
public class ValueOp {

    private String value = "";

    /**
     *定义方法修改value
     */
    public void setValue() {
        synchronized (this) {
            // 如果value不为空，就不能修改，线程等待
            while (!value.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 设置value值
            value = System.currentTimeMillis()+"--"+System.nanoTime();
            System.out.println("set的值是： "+value);
            this.notifyAll();
        }
    }

    /**
     * 定义方法读取value
     */
    public void getValue() {
        synchronized (this) {
            // 如果是空，等待
            while (value.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 不是空，就读取
            System.out.println("get的值是： "+this.value);
            this.value = "";
            this.notifyAll();
        }
    }
}
