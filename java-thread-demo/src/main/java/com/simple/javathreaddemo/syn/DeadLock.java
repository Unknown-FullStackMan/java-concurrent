package com.simple.javathreaddemo.syn;

/**
 * @author Simple
 * @date 2021/3/12 11:14
 */
//死锁：多个线程互相抱着对方需要的资源，形成僵持
//这里以女生化妆为例
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1=new Makeup(0,"灰姑凉");
        Makeup girl2=new Makeup(1,"白雪公主");
        girl1.start();
        girl2.start();

    }

}
//口红
class Lipstick{


}
//镜子
class Mirror{

}
class Makeup extends Thread{

    //需要的资源只有一份，用static修饰来保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    int choice;
    String girlName;//使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }



    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //super.run();
    //化妆，互相持有对方的锁，需要拿到对方的资源
       /*
        第一个人进来想拿口红，1秒之后拿镜子，然后离开
        第二个人进来拿镜子，2秒之后拿口红，然后离开
        于是形成了互相僵持，想拿到对方的东西
        **/

  /*  private void makeup() throws InterruptedException {

        if(choice==0)
        {
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){//一秒中后获得镜子的锁
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }
        else
        {
            synchronized (mirror){//获得镜子的锁
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
                synchronized (lipstick){//一秒中后获得口红的锁
                    System.out.println(this.girlName+"获得口红的锁");
                }
            }
        }
*/
  private void makeup() throws InterruptedException {

      if(choice==0)
      {
          synchronized (lipstick){//获得口红的锁
              System.out.println(this.girlName+"获得口红的锁");
              Thread.sleep(1000);
          }
          synchronized (mirror){//一秒中后获得镜子的锁
              System.out.println(this.girlName+"获得镜子的锁");
          }
      }
      else
      {
          synchronized (mirror){//获得镜子的锁
              System.out.println(this.girlName+"获得镜子的锁");
              Thread.sleep(2000);

          }
          synchronized (lipstick){//一秒中后获得口红的锁
              System.out.println(this.girlName+"获得口红的锁");
          }
      }

  }

}


