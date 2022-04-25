package com.simple.javathreaddemo.FunctionTest;

/**
 * @author Simple
 * @date 2021/3/12 10:12
 */
//一个线程可以给定时间点处于一个状态。这些状态是不反映任何操作系统线程状态的虚拟机状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("");
        });
        Thread.State state = thread.getState();
        System.out.println(state);//new
        thread.start();//启动线程
        state=thread.getState();//runnable
        System.out.println(state);
        while (state!= Thread.State.TERMINATED){//只要线程不终止就输出线程状态
            Thread.sleep(100);
            state=thread.getState();//更新线程状态
            System.out.println(state);//TIME_WAITING

        }
    }
}
