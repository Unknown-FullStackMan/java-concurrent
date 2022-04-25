package com.simple.demoReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Simple
 * @date 2021/3/18 8:28
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        //操作线程的资源类
        MyCache myCache = new MyCache();
        int num = 6;
        for (int i = 0; i < num; i++) {
              final int  fialI=i;
              new Thread(()->{
                  myCache.write(String.valueOf(fialI),String.valueOf(fialI));
              },String.valueOf(i)).start();
        }

        for (int i = 1; i < num; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.read(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }

    }

}

/**
 * 共享锁：读锁
 * 独占锁：写锁
 * 自定义缓存
 */

class MyCache{
    private volatile Map<String,String> map = new HashMap<>();
    //读写锁
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //存 写 只能有一个线程写
    public void write(String key,String value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"线程开始写入");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"线程开始写入OK");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }

    }

    //取 读 可以多个线程读
    public void read(String key){
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "线程开始读取");
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "线程读取OK");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}