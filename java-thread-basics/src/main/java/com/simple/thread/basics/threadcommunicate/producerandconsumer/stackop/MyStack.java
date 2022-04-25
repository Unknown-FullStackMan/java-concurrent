package com.simple.thread.basics.threadcommunicate.producerandconsumer.stackop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Simple
 * @Create 2021/9/3 10:09
 * 操作栈
 */
public class MyStack {

    /**
     * 定义集合模拟栈
     */
    private List<String> list = new ArrayList();
    /**
     * 栈最大存放数量
     */
    private static final int MAX = 10;
    private static int num ;

    /**
     * 定义方法模拟入栈
     */
    public synchronized void push() {
        while (list.size() >= MAX) {
            System.out.println(Thread.currentThread().getName() + " 栈满，不能生产数据，开始等待.......");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        String data = "data--" + num;
        System.out.println(Thread.currentThread().getName()+" 生产了数据，" + data);
        list.add(0,data);
        this.notifyAll();
    }

    /**
     * 定义方法模拟出栈
     */
    public synchronized void pop() {
         while (list.size() <= 0) {
             System.out.println(Thread.currentThread().getName() + " 栈空，不能消费数据，开始等待.......");
             try {
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         System.out.println(Thread.currentThread().getName()+" 消费了数据，" + list.remove(0));
         num--;
         this.notifyAll();
    }

}
