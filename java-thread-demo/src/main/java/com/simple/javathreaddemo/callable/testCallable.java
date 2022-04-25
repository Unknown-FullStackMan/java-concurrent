package com.simple.javathreaddemo.callable;

import java.util.concurrent.Callable;

/**
 * @author Simple
 * @date 2021/3/11 15:38
 */
class testCallable implements Callable<Integer> {
    private String word;

    public testCallable(String word) {
        this.word = word;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": 開始运行！");
        try {
            //如果处理须要2秒
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": 正在处理！");
        System.out.println(Thread.currentThread().getName() + ": " + word + "长度为：" + word.length());
        return Integer.valueOf(word.length());
    }
}