package com.liuwenbin.notes.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Description：多线程同时计数
 * .             使用10个线程并发地对一个初始值为0的数进行100次的加1操作，预期应该得到1000
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 */

public class CountNumber {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    private static Integer number1 = 0;
    private static AtomicInteger number2 = new AtomicInteger(0);
    private static volatile Integer number3 = 0;
    private static Integer number4 = 0;

    public static void main(String[] args) {

        // demo-1 : Integer, 线程不安全
        testInteger();

        // demo-2: AtomicInteger，线程安全
        testAtomicInteger();

        // demo-3 : volatile  线程不安全
        testVolatile();

        // demo-4 : 方法加锁, 线程安全
        testSync();

        // 关闭线程池
        pool.shutdown();
    }

    private static void testInteger() {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10.; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++)
                    number1++;
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("number1 : " + number1 + " ，线程安全？ " + (number1 == 1000));
    }

    private static void testAtomicInteger() {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10.; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++)
                    number2.incrementAndGet();
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("number2 : " + number2.get() + " ，线程安全？ " + (number2.get() == 1000));
    }

    private static void testVolatile() {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10.; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++)
                    number3++;
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("number3 : " + number3 + " ，线程安全？ " + (number3 == 1000));
    }

    private static void testSync() {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10.; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++)
                    add();
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("number4 : " + number4 + " ，线程安全？ " + (number4 == 1000));
    }

    private synchronized static void add() {
        number4++;
    }
}
/* ---------------- output --------------- *
 *
 * number1 : 900 ，线程安全？ false
 * number2 : 1000 ，线程安全？ true
 * number3 : 862 ，线程安全？ false
 * number4 : 1000 ，线程安全？ true
 *
 * -------------------------------------- */