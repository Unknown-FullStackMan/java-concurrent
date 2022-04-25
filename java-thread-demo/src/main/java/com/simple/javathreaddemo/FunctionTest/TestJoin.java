package com.simple.javathreaddemo.FunctionTest;

/**
 * @author Simple
 * @date 2021/3/12 10:08
 */
//join是通过new Thread 对象来调用的，而sleep和yield是通过Thread直接调用
public class TestJoin implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin=new  TestJoin();
        Thread thread=  new Thread( testJoin);
        thread.start();

        for (int i = 0; i < 50; i++) {
            if(i==25)
            {
                thread.join();
            }
            System.out.println("主线程"+i);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("join线程"+i);
        }
    }
}

