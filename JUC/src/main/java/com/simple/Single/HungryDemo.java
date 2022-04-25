package com.simple.Single;

/**
 * @author Simple
 * @date 2021/3/19 13:32
 *
 * 饿汉式
 */
public class HungryDemo {
    /**
     * 可能会浪费空间
     */
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];
    private HungryDemo(){

    }

    private final static HungryDemo HUNGRY =new HungryDemo();
    public static HungryDemo getInstance(){
        return HUNGRY;
    }
}
