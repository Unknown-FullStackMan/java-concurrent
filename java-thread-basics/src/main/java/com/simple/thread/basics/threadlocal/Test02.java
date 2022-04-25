package com.simple.thread.basics.threadlocal;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Simple
 * @Create 2021/9/3 13:07
 * 在多线程环境下，把字符串转换成日期对象
 */

public class Test02 {

    /**
     * 定义SimpleDateFormat对象，把字符串转日期
     * 多个线程使用同一个SimpleDateFormat对象，可能出现线程安全问题。
     * 为每一个线程指定自己的SimpleDateFormat对象，使用ThreadLocal
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
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
                threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
            }

            Date date = threadLocal.get().parse(text);
            System.out.println(i + " -- " + date);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new ParseDate(i)).start();
        }
    }
}
