package com.simple.thread.basics.threadsafe.Atomicity;

/**
 * @Author Simple
 * @Create 2021/8/26 14:17
 */
public class TestSafe {
    public static void main(String[] args) {
        final NumSafe numSafe = new NumSafe();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName()+" ---> : "+ numSafe.getNumSafe());
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
