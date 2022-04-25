package com.simple.thread.basics.threadsafe.Atomicity;

/**
 * @Author Simple
 * @Create 2021/8/26 13:58
 */
public class Num {
    int num;

    public int getNum() {
        /**
         * num++自增操作实现的步骤：
         *      读取num的值
         *      num自增
         *      把自增后的值再赋值给num变量
         */
        return num++;
    }

    /**
     * 解决方法：
     * 可以在getNum()方法加synchronized锁保证原子性
     * 可以在run方法中编写synchronized同步代码块，但是必须使用同一把锁
     * 可以使用原子类：AtomicInteger
     */


}
