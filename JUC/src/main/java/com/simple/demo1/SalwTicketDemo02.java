package com.simple.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Simple
 * @date 2021/3/12 15:26
 * lock锁方式：ReentrantLock
 */


public class SalwTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 0; i < 60; i++) ticket.sale(); },"A").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) ticket.sale(); },"B").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) ticket.sale(); },"C").start();
    }
}

class Ticket2{

    public int number=30;
    Lock lock=new ReentrantLock();

    public  void sale() {
        lock.lock();
        try {
            //业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "获得了第" + number-- + "票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//解锁
        }
    }
}
