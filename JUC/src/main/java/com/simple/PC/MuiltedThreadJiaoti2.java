package com.simple.PC;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Simple
 * @date 2021/3/12 16:44
 */
public class MuiltedThreadJiaoti2 {
    public static void main(String[] args) {
        Data5 data4 = new Data5();
/*        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(data4);
        }*/


        Thread[] threads =new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] =new Thread(data4);
            threads[i].start();
        }



    }
}

class Data5 implements Runnable{
    Lock lock=new ReentrantLock();
    int num=1;
    @Override
    public void run() {
        lock.lock();
        if(num < 1000) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + "\t" + (num++));
            }
        }else return;
        lock.unlock();
    }
}
