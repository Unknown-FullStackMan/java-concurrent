package com.simple.SpinLockTest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Simple
 * @date 2021/3/19 14:45
 */
public class SpinlockDemo {

    // 默认
    // int 0
    //thread null
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"===> mylock");

        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){
            //System.out.println(Thread.currentThread().getName()+" ==> 自旋中~");
        }
    }


    //解锁
    public void myUnlock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"===> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }

}

