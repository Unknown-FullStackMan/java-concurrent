package com.simple.demo1.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/15 9:10
 */

/**
 * 两个对象分别调用synchronized方法时，先输出什么
 * 因为锁不一样，所以耗时短的先输出
 */
public class Test4 {
    public static void main(String[] args) {
        phone4 phone = new phone4();
        phone4 phone02 = new phone4();

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
class phone4{
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
        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("call");
    }

}
