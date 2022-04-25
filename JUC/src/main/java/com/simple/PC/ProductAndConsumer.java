package com.simple.PC;

/**
 * @author Simple
 * @date 2021/3/12 15:38
 */

/*
线程之间的通信问题：生产者和消费者问题  通知 唤醒
线程交替执行 A B操作同一个变量 num=0 A让num+1，B让num-1;
synchronized方式
 **/

public class ProductAndConsumer {
    public static void main(String[] args) {
        Date date = new Date();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }

}

//生产者消费者骨架  (口诀：等待、业务、通知)
class Date{//数字，资源类
    private int num=0;

    public synchronized void increment() throws InterruptedException {
        while (num!=0)   //使用if关键字，在超过两个以上线程数量时会发生虚假唤醒。所有使用while来解决这个问题
        {
            //等待操作
            this.wait();
        }
        num++;
        //执行完++，通知其他线程我已经完成++操作
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while(num==0)
        {
            //等待操作
            this.wait();
        }
        num--;
        //执行完--，通知其他线程我已经完成--操作
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }
}

