package com.simple.javathreaddemo.callable;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Simple
 * @date 2021/3/11 15:40
 */
public class Test2 {
    public static void main(String[] args) {
        FutureTask<String> future = new FutureTask<>(new ThreadCall());
        new  Thread(future).start();

        for (int i = 0; i <200 ; i++) {
            System.out.println("学java被执行了");
        }
    }
}
