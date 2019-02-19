package com.liuwenbin.notes.java.communicate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Description：两个线程交替打印奇偶数
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/16
 */
 
public class VolatileDemo {

    private static int count = 1;

    /**
     * 写操作：由锁保证了线程安全，
     * 读操作：由volatile保证了安全
     */
    private static volatile boolean flag = true;

    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        // 奇数线程
        new Thread(() -> {
            while (count <= 20) {
                if (flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                        flag = false;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }).start();

        // 偶数线程
        new Thread(() -> {
            while (count <= 20) {
                if (!flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                        flag = true;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }).start();
    }
}
/* --------------- output -------------
 *
 * Thread-0 : 1
 * Thread-1 : 2
 * Thread-0 : 3
 * Thread-1 : 4
 * Thread-0 : 5
 * Thread-1 : 6
 * Thread-0 : 7
 * Thread-1 : 8
 * Thread-0 : 9
 * Thread-1 : 10
 * Thread-0 : 11
 * Thread-1 : 12
 * Thread-0 : 13
 * Thread-1 : 14
 * Thread-0 : 15
 * Thread-1 : 16
 * Thread-0 : 17
 * Thread-1 : 18
 * Thread-0 : 19
 * Thread-1 : 20
 *
 * ------------------------------- */
