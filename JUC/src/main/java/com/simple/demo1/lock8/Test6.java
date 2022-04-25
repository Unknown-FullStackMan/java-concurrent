package com.simple.demo1.lock8;

/**
 * @author Simple
 * @date 2021/3/15 9:17
 */

import java.util.concurrent.TimeUnit;

/**
 * 2个对象，把两个synchronized方法改成静态synchronized方法，即static synchronized方法，先输出哪个？
 * 发短信，phone.class全局唯一（两个对象的class类模板只有一个），因为两个方法都被static修饰了，所以两个方法用的是同一个锁，且锁的是类模板
 */
public class Test6 {
    public static void main(String[] args) {
        phone6 phone = new phone6();
        phone6 phone02 = new phone6();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone02.call();
        },"B").start();


    }
}
class phone6{
    public static synchronized void sendSms()
    {

        System.out.println("sendSms");
    }

    public static synchronized  void call()
    {

        System.out.println("call");
    }
}
