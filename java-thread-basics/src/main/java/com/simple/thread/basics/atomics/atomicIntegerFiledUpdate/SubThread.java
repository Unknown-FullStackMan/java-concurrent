package com.simple.thread.basics.atomics.atomicIntegerFiledUpdate;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author Simple
 * @Create 2021/9/2 16:22
 */
public class SubThread extends Thread {
    /**
     * 要更新的对象
     */
    private User user;
    /**
     * 创建AtomicIntegerFieldUpdater更新器
     * 更新的字段必须是volatile修饰和不能为final
     */
    private AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public SubThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        // 在子线程中对user的age字段自增10次
        for (int i = 0; i < 10; i++) {
            System.out.println(updater.getAndIncrement(user));
        }
    }
}
