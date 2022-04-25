package com.simple.FunctionInterface4;

import java.util.function.Supplier;

/**
 * @author Simple
 * @date 2021/3/19 8:42
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->{
            return "1024";
        };
        System.out.println(supplier.get());
    }
}
