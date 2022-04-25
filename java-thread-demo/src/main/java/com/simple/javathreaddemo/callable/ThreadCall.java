package com.simple.javathreaddemo.callable;

import java.util.concurrent.Callable;

/**
 * @author Simple
 * @date 2021/3/11 15:39
 */
public class ThreadCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i <200 ; i++) {
            System.out.println("多线程被执行了");
        }
        return "111";
    }
}
