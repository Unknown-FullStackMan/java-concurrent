package com.simple.javathreaddemo.ThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Simple
 * @date 2021/3/12 14:21
 */
public class TestnewFixedThreadPool {
    public static void main(String[] args) {
        //1创建服务，创建线程池
        //newFixedThreadPool 参数为：线程池大小
        ExecutorService service= Executors.newFixedThreadPool(10);
        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        //2关闭连接
        service.shutdown();
    }
}
class MyThread implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"此生辽阔");
    }

}
