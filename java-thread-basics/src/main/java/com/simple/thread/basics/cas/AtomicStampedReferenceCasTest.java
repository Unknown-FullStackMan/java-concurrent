package com.simple.thread.basics.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author Simple
 * @Create 2021/9/2 15:16
 * 使用AtomicStampedReference解决CAS的ABA问题
 */
public class AtomicStampedReferenceCasTest {
    /**
     * AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
     * 正常在业务操作，这里面比较的都是一个个对象
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

    // CAS compareAndSet : 比较并交换！
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("a1版本号 ---> " + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改操作时，版本号更新 + 1
            System.out.println("修改成功 ---> "+atomicStampedReference.compareAndSet(1, 2,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));

            System.out.println("a2版本号 ---> " + atomicStampedReference.getStamp());
            // 重新把值改回去， 版本号更新 + 1
            System.out.println("修改成功 ---> "+atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            System.out.println("a3版本号 ---> " + atomicStampedReference.getStamp());
            System.out.println("最后修改完的数据 ---> "+atomicStampedReference.getReference());
        }, "a").start();


        Thread.sleep(5000);
        // 乐观锁的原理相同！
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("b1版本号 ---> " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("修改成功 ---> "+atomicStampedReference.compareAndSet(2, 6,
                    stamp, stamp + 1));
            System.out.println("b2版本号 ---> " + atomicStampedReference.getStamp());
        }, "b").start();
    }
}
