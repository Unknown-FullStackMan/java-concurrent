package com.simple.javathreaddemo.FunctionTest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Simple
 * @date 2021/3/12 9:57
 */

/**
 * sleep()：方法是线程类（Thread）的静态方法，让调用线程进入睡眠状态，让出执行机会给其他线程，等到休眠时间结束后，线程进入就绪状态和其他线程一起竞争cpu的执行时间。
 * 因为sleep() 是static静态的方法，他不能改变对象的机锁，当一个synchronized块中调用了sleep() 方法，线程虽然进入休眠，但是对象的机锁没有被释放，其他线程依然无法访问这个对象
 * wait()：wait()是Object类的方法，当一个线程执行到wait方法时，它就进入到一个和该对象相关的等待池，同时释放对象的机锁，使得其他线程能够访问，可以通过notify，notifyAll方法来唤醒等待的线程
 */


//模拟倒计时
public class TestSleep implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        tenDown();
        //打印当前系统时间
        Date startTime=new Date(System.currentTimeMillis());
        while(true)
        {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime=new Date(System.currentTimeMillis());

        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num=10;
        while(true)
        {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0)
            {
                break;
            }
        }
    }

    @Override
    public void run() {
    }
}
