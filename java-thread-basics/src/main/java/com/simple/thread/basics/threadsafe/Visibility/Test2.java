package com.simple.thread.basics.threadsafe.Visibility;

/**
 * @Author Simple
 * @Create 2021/8/26 16:26
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        new Thread(myTask).start();

        Thread.sleep(100);
        /**
         * main线程取消子线程
         *      可能出现以下情况：
         *      main线程调用了setToCancel()方法，把toCancel修改成true，但是子线程可能看不到，子线程里面一直为false
         *
         * 导致子线程看不到main线程对toCancel修改更新的原因可能：
         *      1） JIT即时编译器 可能 会对方法种的while循环进行优化为：
         *       if (!toCancel){
         *          while(true) {
         *                 if(doSomeThing()) {
         *                     break;
         *                 }
         *             }
         *       }
         *
         *       2) 可能与计算机的存储系统有关，两个线程可能运行在两个cpu内核上，两个cpu内核间共享变量改变后两个线程看不到改变
         */
        myTask.setToCancel();



    }

    static class MyTask implements Runnable{
        private boolean toCancel = false;
        public void run() {
            while (!toCancel){
                if(doSomeThing()) {
                    break;
                }
            }
            if (toCancel) {
                System.out.println("任务取消");
            } else {
                System.out.println("任务正常结束");
            }
        }
        private boolean doSomeThing()  {
            System.out.println("执行某个任务");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        public void setToCancel(){
            toCancel = true;
            System.out.println("设置任务取消");
        }
    }
}
