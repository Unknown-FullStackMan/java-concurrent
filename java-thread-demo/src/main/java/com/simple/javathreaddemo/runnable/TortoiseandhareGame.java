package com.simple.javathreaddemo.runnable;

/**
 * @author Simple
 * @date 2021/3/11 15:19
 */
public class TortoiseandhareGame implements Runnable {

    private static String winner;  //胜利者

    @Override
    public void run() {
        for (int i = 1;i <=101 ;i++){
            if(Thread.currentThread().getName().equals("兔子") && i%20==0){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");
        }
    }

    private  boolean gameOver(int steps){
        if(winner != null){
            return true;
        } {
            if (steps > 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is:" + winner);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TortoiseandhareGame race = new TortoiseandhareGame();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

}
