package com.simple.demo1.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/12 17:23
 */

/**
 * 给发短信方法加延时4s，程序的执行情况：经过4s之后打印发短信，   然后立马打印打电话
 * 如果把主函数中延时改为5s，那么程序运行情况是经过4s打印发送短信，然后经过1s打印打电话（主程序的延时是同时进行的）
 */
public class Test2 {
    public static void main(String[] args) {
        phone2 phone = new phone2();

        new Thread(()->{
            phone.sendSms();

        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(5); //如果把1修改为5，情况变化
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();

    }
}
class phone2{
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


}
