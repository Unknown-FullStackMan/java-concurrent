package com.simple.unsafeList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Simple
 * @date 2021/3/15 9:47
 */
//java.utill.ConcurrentModificationException  并发修改异常
/**
 * 解决方法
 * 1.使用Vector，线程安全  new Vector 不推荐
 * 2.我们可以把arraylist变成安全的，数组有工具类叫Arrays，集合有工具类叫Collections。
 * 3.JUC.CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略；多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）在写入的时候复制了一份避免覆盖，造成数据问题！读写分离
 *
 * CopyOnWriteArrayList 比 Vector Nb 在哪里？
 * 只要有synchronized的方法，相对效率比较低，Vector的底层add是synchronized修饰方法的，新版的是lock锁，并且是写入时复制一份再设置一份新的
 */

public class ListTest {
    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();   不安全


        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        List list = new CopyOnWriteArrayList<>();


        for (int i = 1; i <=100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }
}
