package com.simple.FunctionInterface4;

import java.util.function.Function;

/**
 * @author Simple
 * @date 2021/3/19 8:37
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String,String> function = (str)->{
          return str;
        };
        System.out.println(function.apply("aaaa"));
    }
}
