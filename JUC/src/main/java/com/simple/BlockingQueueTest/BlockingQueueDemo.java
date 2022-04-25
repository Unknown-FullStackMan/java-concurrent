package com.simple.BlockingQueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Simple
 * @date 2021/3/18 9:29
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
            test01();
            test02();
    }

    public static void test01(){
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element()); //队首元素 为空，会报异常
        //        抛出异常 java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    public static void test02(){
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.peek());
        //        添加不会抛出异常，返回false
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        移除不会抛出异常，返回null
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek()); //查看队首 为空，不异常
    }

    /**
     * 样子
     * @throws InterruptedException
     */
    public static void test03() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //      一直阻塞，不会返回值
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

//        若队列已满，再添加，则阻塞等待添加,返回被取出的值
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        移除不会抛出异常，返回null
    }

    public void test04() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        System.out.println("开始等待");
        blockingQueue.offer("d",2, TimeUnit.SECONDS);
        System.out.println("等待结束");
        System.out.println("=================取值=====================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println("取值开始等待");
        blockingQueue.poll(2,TimeUnit.SECONDS);//超过两秒，我们就不等待了
        System.out.println("取值结束等待");
    }

}
