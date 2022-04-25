package com.simple.javathreaddemo.thread;

/**
 * @author Simple
 * @date 2021/3/11 14:45
 */
public class TestWebDownLoader  extends Thread{

    private String url; //保存网络图片地址

    private String name;//保存文件名

    public TestWebDownLoader(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("图片下载成功,名为:"+name);
    }

    public static void main(String[] args) {
        TestWebDownLoader t1 = new TestWebDownLoader("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=1561546013,1259770086&fm=85&s=1A21EC02EE337FAF0854119903001062","1.jpg");
        TestWebDownLoader t2 = new TestWebDownLoader("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=3506652242,2368086075&fm=85&s=8C9F875066675AAE078DE4D6030050F1","2.jpg");
        TestWebDownLoader t3 = new TestWebDownLoader("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=2623032014,2137091052&fm=85&s=F4C2BE56F74162EE0E5EEC7C03004071","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }


}
