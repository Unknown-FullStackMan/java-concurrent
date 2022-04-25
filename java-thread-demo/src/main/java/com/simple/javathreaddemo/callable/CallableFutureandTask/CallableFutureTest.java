package com.simple.javathreaddemo.callable.CallableFutureandTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Simple
 * @date 2021/3/11 16:18
 */
public class CallableFutureTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //创建Callable对象任务
        CallableDemo caltask = new CallableDemo();
        //提交任务并获取执行结果
        Future<Integer> future = executorService.submit(caltask);
        //关闭线程池
        executorService.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");

            if (future.get() != null){
                //输出获取到的结果
                System.out.println("future.get()--->"+future.get());
            }else {
                System.out.println("未获取到结果!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");
    }
}
