package com.simple.thread.basic.threadandrunnable;

import com.simple.thread.basics.threadcreate.MyRunnable01;
import com.simple.thread.basics.threadfunction.currenthread.MyThread01;
import org.junit.Test;

/**
 * @Author Simple
 * @Create 2021/8/24 15:33
 */
public class ThreadTest {

    @Test
    public void testMyThread(){
        MyThread01 myThread = new MyThread01("线程01");
        myThread.start();
    }


    @Test
    public void testMyRunnable(){
        MyRunnable01 myRunnable = new MyRunnable01();
        Thread thread = new Thread(myRunnable,"线程02");
        thread.start();
    }
}
