package com.simple.javathreaddemo.callable.CallableFutureandTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Simple
 * @date 2021/3/12 8:47
 */
public class CallableFutureTaskTest {
    public static void main(String[] args) {

        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        //创建Callable对象任务
        CallableDemo calTask = new CallableDemo();
        //创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(calTask);
        //执行任务
        es.submit(futureTask);
        es.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");

            if (futureTask.get() != null){
                //输出获取到的结果
                System.out.println("future.get()--->"+futureTask.get());
            }else {
                System.out.println("未获取到结果!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");
    }
}
