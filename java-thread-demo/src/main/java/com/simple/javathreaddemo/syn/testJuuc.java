package com.simple.javathreaddemo.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Simple
 * @date 2021/3/12 11:09
 */

//测试JUC安全类型集合
public class testJuuc   {
    public static void main(String[] args) throws InterruptedException {
         CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(Thread.currentThread().getName());

            }).start();
        }

        Thread.sleep(1000);//休息一会再打印，电脑运行速度太快了。线程里add还没执行完就执行主线程的打印语句。会导致打印结果偏小，但最后实际结果其实还是10000
        System.out.println(list.size());

    }
}

