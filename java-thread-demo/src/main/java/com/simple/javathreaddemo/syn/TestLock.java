package com.simple.javathreaddemo.syn;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author Simple
 * @date 2021/3/12 11:26
 */
//测试Lock锁
public class TestLock implements Runnable {
    int ticketNums=1000;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        TestLock testLock=new TestLock();
        // new Thread(testLock,"1").start();
        new Thread(testLock,"2").start();
        new Thread(testLock,"3").start();
        new Thread(testLock,"4").start();
    }
    @Override
    public void run() {
        while(true)
        {
            try {
                lock.lock();
                if(ticketNums>0)
                {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"获得了第"+ticketNums--+"票");
                }
                else
                {
                    break;
                }
            }
            finally {
                lock.unlock();
            }
        }
    }
}

