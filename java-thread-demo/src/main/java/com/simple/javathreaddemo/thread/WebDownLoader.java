package com.simple.javathreaddemo.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Simple
 * @date 2021/3/11 14:42
 * 下载器
 */

public class WebDownLoader {

    //下载方法
    public void downLoader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("文件下载失败，IO有问题");
        }
    }
}
