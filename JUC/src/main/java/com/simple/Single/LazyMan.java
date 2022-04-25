package com.simple.Single;

/**
 * @author Simple
 * @date 2021/3/19 13:35
 *
 * 懒汉式
 */
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"  OK");
    }

    private  volatile static LazyMan lazyMan;

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null) {
                    lazyMan = new LazyMan(); //不是原子性操作
                    /*
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 就有可能出现指令重排问题
                     * 比如执行的顺序是 1 3 2 等
                     * 我们就可以添加 volatile 保证指令重排问题
                     *
                     * */
                }
            }
        }
        return lazyMan;
    }

    //多线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               LazyMan.getInstance();
            }).start();

        }
    }
}
