package com.simple.thread.basics.threadfunction.setDaemon;


/**
 * @Author Simple
 * @Create 2021/8/26 10:42
 */
public class SubDaemonThread extends Thread{

    /**
     * Java中的线程分为用户现场和守护线程
     * 守护线程是为其他线程提供服务的线程，如垃圾回收器（GC）就是一个典型的守护线程
     * 守护线程，不能单独运行，当JVM中没有其他用户线程时，只有守护线程，守护线程会自动销毁，JVM会退出
     */
    @Override
    public void run() {
       while (true) {
           System.out.println("Sub Thread---");
       }
    }
}
