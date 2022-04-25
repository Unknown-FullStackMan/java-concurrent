package com.simple.javathreaddemo.callable.CallableFutureandTask;

import java.util.concurrent.Callable;

/**
 * @author Simple
 * @date 2021/3/11 16:15
 */
public class CallableDemo implements Callable<Integer> {

    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable子线程开始计算!");
        Thread.sleep(2000);
        for (int i = 0;i <=100;i++){
            sum=sum+i;
        }
        System.out.println("Callable子线程计算结束!");
        return sum;
    }
}
