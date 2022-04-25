package com.simple.javathreaddemo.callable;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author Simple
 * @date 2021/3/11 15:38
 */
public class Test1 {
    public static void main(String[] args) {
        String[] words = {"first","seconde","simple","Callable"};

        //创建一个线程池
        ExecutorService poll = Executors.newCachedThreadPool();
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();

        for (String word: words){
            Callable<Integer> callable = new testCallable(word);
            Future<Integer> future = poll.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : set){
            try {
                sum += future.get();
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
        }
        System.out.println("数组中全部单词的总长度为：" + sum);

        poll.shutdown();
    }

}
