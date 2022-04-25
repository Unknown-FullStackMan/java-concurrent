package com.simple.thread.basics.atomics.atomicIntegerFiledUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Simple
 * @Create 2021/9/2 16:21
 */
@Data
@AllArgsConstructor
public class User {

    int id;

    volatile int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
