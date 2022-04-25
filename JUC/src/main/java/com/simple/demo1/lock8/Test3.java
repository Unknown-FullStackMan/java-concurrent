package com.simple.demo1.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/15 8:43
 */

/**
 * 当调用普通方法，而不是synchronized方法时
 * 先执行普通方法，因为普通方法没有锁，不受锁的影响
 */
public class Test3 {
    public static void main(String[] args) {
        phone3 phone = new phone3();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.sayHello();
        },"B").start();


    }
}
class phone3{
    public synchronized void sendSms()
    {
        try {
            TimeUnit.SECONDS.sleep(4);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized  void call()
    {
        System.out.println("call");
    }
    //没有锁，步受锁影响
    public  void sayHello()
    {
        System.out.println("hello");
    }
}
