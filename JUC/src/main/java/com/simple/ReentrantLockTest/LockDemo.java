package com.simple.ReentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Simple
 * @date 2021/3/19 14:38
 */
public class LockDemo {
    public static void main(String[] args) {
        Phone2 phone2  = new Phone2();
        new Thread(()->{
            phone2.sms();
        }).start();
        new Thread(()->{
            phone2.sms();
        }).start();
    }
}
class Phone2{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();//细节：这个两把锁，两个钥匙
//        lock 锁必须配对，否则就是死锁在里面
        try {
            System.out.println(Thread.currentThread().getName()+"=>sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"=>call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
