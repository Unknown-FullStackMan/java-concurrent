package com.simple.thread.basics.atomics.atomicreference;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Simple
 * @Create 2021/9/2 16:31
 * AtomicReference原子操作对象
 * 可能会出现ABA问题：可使用AtomicStampedReference类解决
 */
public class Test01 {

    /**
     * 创建一个AtomicReference对象
     */
    static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(new Random().nextInt(20));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (atomicReference.compareAndSet("abc","def")) {
                    System.out.println(Thread.currentThread().getName()+"---> 把字符串abc更改为def ");
                } else if (atomicReference.compareAndSet("def","adc")) {
                    System.out.println(Thread.currentThread().getName()+"---> 把字符串def还原为abc ");
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicReference.get());
    }

}
