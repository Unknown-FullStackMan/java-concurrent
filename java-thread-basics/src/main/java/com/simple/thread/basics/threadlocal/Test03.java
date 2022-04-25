package com.simple.thread.basics.threadlocal;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Simple
 * @Create 2021/9/3 13:07
 * 设置ThreadLocal的初始值
 */

public class Test03 {

    /**
     * ThreadLocal初始值，定义ThreadLocal类的子类，在子类中重写initialValue()方法。指定一个初始值
     */
    static class SubThreadLocal extends ThreadLocal<Date> {
        @Override
        protected Date initialValue() {
            return new Date(System.currentTimeMillis()-1000*60*10);
        }
    }
    static SubThreadLocal threadLocal = new SubThreadLocal();

    static class ParseDate implements Runnable {

        private int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }

        @SneakyThrows
        @Override
        public void run() {
            String text = "2068年11月22日 08:27:" + i%60;
            if (threadLocal.get() == null) {
                System.out.println("###########################初始值为空##########################");
                threadLocal.set(new Date());
            }
            Date date = threadLocal.get();
            System.out.println(i + " -- " + date);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new ParseDate(i)).start();
        }
    }
}
