package com.liuwenbin.notes.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 刘文斌 2018-11-13
 **/

public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    private void fun() {
        // 1 上锁
        lock.lock();
        try {
            // 2 锁内的业务操作
            for (int i = 0; i < 50; i++) {
                System.out.print(i + ", ");
            }
        } finally {
            // 3 解锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo a = new ReentrantLockDemo();
        ReentrantLockDemo b = new ReentrantLockDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();

        // demo-1: 锁有效
        executorService.execute(() -> a.fun());
        executorService.execute(() -> a.fun());

        // demo-2: 锁无效
        executorService.execute(() -> a.fun());
        executorService.execute(() -> b.fun());
    }
}
/**
 * ------------------ output: ------------------------
 *
 * 运行某个demo，先将其他demo注释掉
 * 看打印结果，如果是0,1，...49, 0,1,...49      -> 锁有效
 *          如果是0,1,2，...0,1,...49,...49    -> 锁无效
 *
 * ---------------------------------------------------
 */
