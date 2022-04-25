package com.simple.demo1.lock8;

/**
 * @author Simple
 * @date 2021/3/15 9:19
 */

import java.util.concurrent.TimeUnit;

/**
 *同一个对象，把两个synchronized方法中的一个改成静态synchronized方法，即static synchronized方法，另一个为普通synchronized方法，先输出哪个？
 *
 * 答：打电话，锁的对象不一样，一个锁的是类模板，一个锁的是对象，(两把锁)。后面调用的方法不需要去等待锁
 */
public class Test7 {
    public static void main(String[] args) {
        phone7 phone = new phone7();

        new Thread(()->{
            phone.sendSms();
        },"A").start();
        new Thread(()->{
            phone.call();
        },"B").start();

   /*     try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }*/



    }
}
class phone7{

    //静态同步方法，锁的是Class类模板
    public  static synchronized void sendSms()
    {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }


    //普遍同步方法，锁的是调用者
    public    synchronized  void call()
    {

        System.out.println("call");
    }
}
