package com.simple.demo1;

/**
 * @author Simple
 * @date 2021/3/12 15:08
 *
 * synchronized方式
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类, 把资源类丢入线程
        Ticket ticket = new Ticket();
        //函数式接口，jdk1.8 lambda表达式（参数）->{代码}
        new Thread(()->{//3个线程操作同一个资源，这种方式对于Ticket类来说实现类解耦，因为Ticket类是一个纯类，没有实现Runnable接口
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();



        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();


    }
}
class Ticket {

    public int number = 600;
    //synchronized本质是队列，锁
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "获得了第" + number-- + "票");
        }

    }
}

