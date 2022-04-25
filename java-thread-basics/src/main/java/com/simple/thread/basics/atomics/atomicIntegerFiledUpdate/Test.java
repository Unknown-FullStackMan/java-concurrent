package com.simple.thread.basics.atomics.atomicIntegerFiledUpdate;

/**
 * @Author Simple
 * @Create 2021/9/2 16:26
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(1024,0);

        for (int i = 0; i < 10; i++) {
            new SubThread(user).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }
}
