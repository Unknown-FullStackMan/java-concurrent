package com.simple.demo1.lock8;
import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/12 16:58
 */

/*
 8锁，就是关于所得8个问题
 问题1：标准情况下，先打印发短信，还是先打印打电话？结果是先打印发短信，后打印打电话
 原因：不能回答先调用A线程，这是错误的，不是先调用先执行，这是锁的问题，因为被Synchronized修饰的
 方法，锁的对象是方法的调用者,所以调用两个方法的对象都是phone,但是现在phone只有一个，也就是说着两个方
 法现在用的是同一把锁，谁先拿到，谁就先执行
*/


public class Test1 {
    public static void main(String[] args) {
        phone phone = new phone();
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
class phone{


    public synchronized void sendSms()
    {

        System.out.println("sendSms");
    }
    public synchronized  void call()
    {
        System.out.println("call");
    }
}

