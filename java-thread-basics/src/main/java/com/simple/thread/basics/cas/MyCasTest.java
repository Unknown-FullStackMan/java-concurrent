package com.simple.thread.basics.cas;

/**
 * @Author Simple
 * @Create 2021/9/2 14:48
 */
public class MyCasTest {

    public static void main(String[] args) {
        final CASCounter casCounter = new CASCounter();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(casCounter.incrementAndGet());
                }
            }).start();
        }
    }
}
class CASCounter {
    /**
     * 使用volatile修饰value值，使线程间可见
     */
    volatile private long value;

    public long getValue() {
        return value;
    }

    /**
     * 定义compare and swap方法
     * @param expectedValue
     * @param newValue
     * @return
     */
    private boolean compareAndSwap(long expectedValue, long newValue) {
        // 如果当前value的值与期望的expectedValue值一样，就把value替换成newValue
        synchronized (this) {
            if (value == expectedValue) {
                value = newValue;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 定义自增的方法
     * @return
     */
    public long incrementAndGet(){
        long oldValue;
        long newValue;
        do{
            oldValue = value;
            newValue = oldValue+1;
        }while (!compareAndSwap(oldValue,newValue));
        return newValue;
    }
}
