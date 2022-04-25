package com.simple.Single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Simple
 * @date 2021/3/19 13:49
 */
public class LazyMan2 {
    private static boolean key = false;

    private LazyMan2(){
        synchronized(LazyMan.class){
            if (key == false){
                key = true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private volatile static LazyMan2 lazyMan2;
    //    双重检测锁模式 简称 DCL 懒汉式
    public static LazyMan2 getInstance(){
//        需要加锁
        if (lazyMan2 == null){
            lazyMan2 = new LazyMan2();
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
        return lazyMan2;
    }
    //    单线程下是 ok 的
//    但是如果是并发的
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Java 中有反射
//        LazyMan instance = LazyMan.getInstance();
//        Field key = LazyMan2.class.getDeclaredField("key");
//        key.setAccessible(true);
//
        Constructor<LazyMan2> declaredConstructor = LazyMan2.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan2 lazyMan2 = declaredConstructor.newInstance();

        LazyMan2 instance = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(lazyMan2);
        System.out.println(instance == lazyMan2);

    }

}
