package com.simple.FunctionInterface4;

import java.util.function.Consumer;

/**
 * @author Simple
 * @date 2021/3/19 8:43
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("abc");

    }
}
