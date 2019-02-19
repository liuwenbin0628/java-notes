package com.liuwenbin.notes.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 刘文斌 2018-11-12
 **/

public class SynchronizedDemo {

    private void fun1() {
        // 作用于同一个对象
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                System.out.print(i + ", ");
            }
        }
    }

    private void fun2() {
        // 作用于同一个类
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 50; i++) {
                System.out.print(i + ", ");
            }
        }
    }

    // 作用于同一个对象（调用这个方法的对象）
    private synchronized void fun3() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " ");
        }
    }

    // 作用于同一个类
    private synchronized static void fun4() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " ");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo a = new SynchronizedDemo();
        SynchronizedDemo b = new SynchronizedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();

        // demo-1: 锁有效
        executorService.execute(() -> a.fun1());
        executorService.execute(() -> a.fun1());

        // demo-2：锁无效
        executorService.execute(() -> a.fun1());
        executorService.execute(() -> b.fun1());

        // demo-3：锁有效
        executorService.execute(() -> a.fun2());
        executorService.execute(() -> b.fun2());

        // demo-4；锁无效
        executorService.execute(() -> a.fun3());
        executorService.execute(() -> b.fun3());

        // demo-5：锁有效
        executorService.execute(() -> a.fun4());
        executorService.execute(() -> b.fun4());

    }
}
/**
 * ------------------ output: ------------------------
 *
 * 运行某个demo，先将其他demo注释掉
 * 看打印结果，如果是0,1，...49, 0,1,...49      -> 锁有效
 *          如果是0,1,2，...0,1,...49,...49   -> 锁无效
 *
 * ---------------------------------------------------
 */
