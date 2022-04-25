package com.simple.FunctionInterface4;

import java.util.function.Predicate;

/**
 * @author Simple
 * @date 2021/3/19 8:39
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = (str)->{
          return str.isEmpty();
        };

        System.out.println(predicate.test("aaa"));
        System.out.println(predicate.test(""));
    }
}
