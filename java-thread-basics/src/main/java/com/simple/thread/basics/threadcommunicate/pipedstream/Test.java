package com.simple.thread.basics.threadcommunicate.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author Simple
 * @Create 2021/9/3 11:01
 * 通过PipedInputStream和PipedOutStream管道字节流在线程之间传递数据
 */
public class Test {
    public static void main(String[] args) {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        // 在输入管道流与输出管道流之间建立连接
        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建线程，向流中写数据
        new Thread(()->{
            writeData(outputStream);
        }).start();

        new Thread(()->{
            readData(inputStream);
        }).start();
    }

    /**
     * 定义方法，从管道流中写入数据
     */
    public static void writeData(PipedOutputStream outputStream) {
        String data;
        try {
            for (int i = 1; i <= 100; i++) {
                if (i%10 == 0) {
                    data = "data:"+i+"\n";
                } else {
                    data = "data:"+i+" ";
                }
                // 把字节数组写入到管道中
                outputStream.write(data.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 定义方法，从管道流中读取数据
     */
    public static void readData(PipedInputStream inputStream) {
        byte[] bytes = new byte[1024];
        try {
            // 从管道流中读取字节保存到字节数组中
            int len = inputStream.read(bytes);
            // 返回读取到的字节数，没有读到数据返回-1
            while (len != -1) {
                // 把bytes数组从0开始到len个字节转换成String字符串输出
                System.out.println(new String(bytes,0,len));
                // 继续读
                len = inputStream.read(bytes);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
