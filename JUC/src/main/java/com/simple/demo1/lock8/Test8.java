package com.simple.demo1.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/15 9:40
 */

/**
 * 两个对象，把两个synchronized方法中的一个改成静态synchronized方法，即static synchronized方法，另一个为普通synchronized方法，先输出哪个？
 * 答：打电话，还是锁的对象不一样
 */
public class Test8 {
    public static void main(String[] args) {
        phone8 phone = new phone8();
        phone8 phone02 = new phone8();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        new Thread(()->{
            phone02.call();
        },"B").start();

   /*     try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }*/



    }
}
class phone8{

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
