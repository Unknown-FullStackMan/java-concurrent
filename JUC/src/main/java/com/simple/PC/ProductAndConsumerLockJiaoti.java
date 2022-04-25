package com.simple.PC;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Simple
 * @date 2021/3/12 16:01
 */

//A执行完通知 B，B执行完通知C
public class ProductAndConsumerLockJiaoti {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data3.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{

            for (int i = 0; i <10; i++) {
                try {
                    data3.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"B").start();
        new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    data3.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}

class Data3{
    Lock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3= lock.newCondition();
    private int state=1;
    int num=1;

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while(state!=1)
            {
                condition1.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println((num++)+"\t"+Thread.currentThread().getName()+"=>AAAAA");
            }
            condition2.signal();//A执行完通知B
            state=2;//改变state的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while(state!=2)
            {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println((num++)+"\t"+Thread.currentThread().getName()+"=>BBBBB");
            }
            condition3.signal();//A执行完通知B
            state=3;//改变state的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while(state!=3)
            {
                condition3.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println((num++)+"\t"+Thread.currentThread().getName()+"=>CCCCC");
            }
            condition1.signal();//A执行完通知B
            state=1;//改变state的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
