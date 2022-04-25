package com.simple.demo1.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/15 9:13
 */

/**
 * 一个对象，把两个synchronized方法改成静态synchronized方法，即static synchronized方法，先输出哪个？
 * 发短信：static方法在类加载时就有了，锁的对象是class模板，因为class对象是唯一的 phone.class全局唯一，因为两个方法都被static修饰了，所以两个方法用的是同一个锁，且锁的是类模板
 */
public class Test5 {
    public static void main(String[] args) {
        phone5 phone = new phone5();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();


    }
}
class phone5{
    public static synchronized void sendSms()
    {
        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("sendSms");
    }

    public static synchronized  void call()
    {
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("call");
    }
}
