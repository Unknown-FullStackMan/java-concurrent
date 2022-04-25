package com.simple.javathreaddemo.FunctionTest;

/**
 * @author Simple
 * @date 2021/3/12 9:52
 */
//不推荐使用jdk提供的stop(),destory()方法，建议使用一个标志位进行终止变量，当flag=false,则线程终止运行
public class Teststop implements Runnable {
    //1.线程中定义线程体使用的标识
    private boolean flag = true;
    @Override
    public void run (){
    //2 .线程体使用该标识
        while (flag) {
            System.out.println ( "run. . . Thread" );
        }
    }
    //3.对外提供方法改变标识
    public void stop(){
        this.flag = false;

    }

    public static void main(String[] args) {
        Teststop testStop = new Teststop();
        new Thread(testStop).start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("main"+i);
            if (i==900){
                testStop.stop();
                System.out.println("run线程停止了！");
            }
        }
    }

}


