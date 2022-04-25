package com.simple.thread.basics.threadsafe.Atomicity;

/**
 * @Author Simple
 * @Create 2021/8/26 13:59
 */
public class Test {
    public static void main(String[] args) {
        final Num num = new Num();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                        while (true) {
                            System.out.println(Thread.currentThread().getName() + " ---> : " + num.getNum());
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
