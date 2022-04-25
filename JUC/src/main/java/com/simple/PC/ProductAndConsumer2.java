package com.simple.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Simple
 * @date 2021/3/12 15:56
 *
 * Lock+Condition方式
 */
public class ProductAndConsumer2 {
    public static void main(String[] args) {
        Date2 date = new Date2();
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
                    date.increment();
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
class Date2{
    private int num=0;
    Lock lock=new ReentrantLock();    //Lock取代synchronized
    Condition condition = lock.newCondition();  //取代了对象监视器方法的使用  wait/notify

    public  void increment() throws InterruptedException {

        try {
            lock.lock();//锁
            //业务代码
            while(num!=0)
            {
                //等待操作
                condition.await();
            }
            num++;
            //执行完++，通知其他线程我已经完成++操作
            System.out.println(Thread.currentThread().getName()+"=>"+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }

    }

    public  void decrement() throws InterruptedException {
        try {
            lock.lock();

            while(num==0)
            {
                //等待操作
                condition.await();
            }
            num--;
            //执行完--，通知其他线程我已经完成--操作
            System.out.println(Thread.currentThread().getName()+"=>"+num);
            condition.signalAll();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
