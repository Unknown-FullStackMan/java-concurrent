package com.simple.PC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Simple
 * @date 2021/3/12 16:15
 */
public class MuiltedThreadJiaoti {
    public static void main(String[] args) {
        Data4 data4 = new Data4();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data4.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    data4.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    data4.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    data4.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    data4.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    data4.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int j = 0; j < 10; j++) {
                try {
                    data4.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    data4.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    data4.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    data4.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();



    }
}

class Data4 {
    Lock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    private int state=1;
    int num=1;

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while(state!=1)
            {
                condition1.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"=>"+"\t"+(num++));
            }
            condition2.signal();//A执行完通知B
            state=2;//改变state的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while(state!=2)
            {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"=>"+"\t"+(num++));
            }
            condition1.signal();//A执行完通知B
            state=1;//改变state的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

