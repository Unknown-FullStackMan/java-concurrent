package com.simple.javathreaddemo.Proxy;

/**
 * @author Simple
 * @date 2021/3/12 9:01
 */

/**
 * 静态代理：真实对象和代理对象都要实现同一个接口；代理对象代理真实对象
 * 好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {


        new WeddingCompany(new You()).HappyMarry();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程的静态代理,Thread是代理对象。new的Runnable是真实对象！");
            }
        }).start();
    }

}

interface Marry{
    void HappyMarry();
}


//真实角色，you结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我来结婚，开心！");
    }
}

//代理角色，婚庆公司
class WeddingCompany implements Marry{

    //真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();  //真实对象
        after();
    }

    private void before(){
        System.out.println("结婚前，布置场景");
    }
    private void after(){
        System.out.println("结婚后，收尾款");
    }
}




