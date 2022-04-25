package com.simple.VolatileTest;
import java.util.concurrent.TimeUnit;


/**
 * @author Simple
 * @date 2021/3/19 11:32
 */


public class VolatileDemo {
    //    如果不加 volatile 程序会死循环
//    加了volatile 是可以保证可见性的
    private volatile static Integer number = 0;

    public static void main(String[] args) {
//        main 线程
//        子线程1
        new Thread(()->{
            while (number==0){}
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        子线程2
        new Thread(()->{
            while (number==0){
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 1;
        System.out.println(number);
    }
}

