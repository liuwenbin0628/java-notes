package com.liuwenbin.notes.java.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @ Description：单例的客户端
 * .              顺便在这里说一下单例模式的好处：
 * .              (1)对于频繁使用的对象，可以省略创建对象所花费的时间，这对于那些重量级对象而言，
 * .                 是非常可观的一笔系统开销；
 * .              (2)由于 new 操作的次数减少，因而对系统内存的使用频率也会降低，这将减轻 GC 压力，
 * .                 缩短 GC 停顿时间。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/2
 * @ Since      : JDK1.8
 */

public class Client {

    public static void main(String[] args) {

        // 1 -------------------------
        System.out.println(" ================== 功能测试 ===================== ");
        Singleton01 a1 = Singleton01.getInstance();
        Singleton01 a2 = Singleton01.getInstance();
        // 单线程没问题, 高并发情况下会出问题
        // TODO：模拟多线程下线程不安全的情况
        System.out.println("懒汉式：   a1 = " + a1 + "; a2 = " + a2);

        Singleton02 b1 = Singleton02.getInstance();
        Singleton02 b2 = Singleton02.getInstance();
        System.out.println("饿汉式：   b1 = " + b1 + "; b2 = " + b2);

        Singleton03 c1 = Singleton03.getInstance();
        Singleton03 c2 = Singleton03.getInstance();
        System.out.println("懒汉式：   c1 = " + c1 + "; c2 = " + c2);

        Singleton04 d1 = Singleton04.getInstance();
        Singleton04 d2 = Singleton04.getInstance();
        System.out.println("双重锁：   d1 = " + d1 + "; d2 = " + d2);

        Singleton05 e1 = Singleton05.getInstance();
        Singleton05 e2 = Singleton05.getInstance();
        System.out.println("静态内部类: e1 = " + e1 + "; e2 = " + e2);

        Singleton06 f1 = Singleton06.INSTANCE;
        Singleton06 f2 = Singleton06.INSTANCE;
        System.out.println("枚举：     f1 = " + f1 + "; f2 = " + f2);

        // 2 --------------------------
        System.out.println(" =================== 性能测试 ===================== ");
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch latch1 = new CountDownLatch(1000000);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pool.execute(() -> Singleton03.getInstance());
            latch1.countDown();
        }
        try {
            latch1.await();
        } catch (InterruptedException e) {}
        long end1 = System.currentTimeMillis();
        System.out.println("懒汉式方法直接加锁花了：" + (end1 - start1) + " millis");

        CountDownLatch latch2 = new CountDownLatch(1000000);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pool.execute(() -> Singleton04.getInstance());
            latch2.countDown();
        }
        try {
            latch2.await();
        } catch (InterruptedException e) {}
        long end2 = System.currentTimeMillis();
        System.out.println("懒汉式双重校验锁花了：  " + (end2 - start2) + " millis");

    }
}
/*-------------- output --------------
 *
 *   ================== 功能测试 =====================
 * 懒汉式：   a1 = com.liuwenbin.notes.java.singleton.Singleton01@1b6d3586; a2 = com.liuwenbin.notes.java.singleton.Singleton01@1b6d3586
 * 饿汉式：   b1 = com.liuwenbin.notes.java.singleton.Singleton02@4554617c; b2 = com.liuwenbin.notes.java.singleton.Singleton02@4554617c
 * 懒汉式：   c1 = com.liuwenbin.notes.java.singleton.Singleton03@74a14482; c2 = com.liuwenbin.notes.java.singleton.Singleton03@74a14482
 * 双重锁：   d1 = com.liuwenbin.notes.java.singleton.Singleton04@1540e19d; d2 = com.liuwenbin.notes.java.singleton.Singleton04@1540e19d
 * 静态内部类: e1 = com.liuwenbin.notes.java.singleton.Singleton05@677327b6; e2 = com.liuwenbin.notes.java.singleton.Singleton05@677327b6
 * 枚举：     f1 = com.liuwenbin.notes.java.singleton.Singleton06@21685669; f2 = com.liuwenbin.notes.java.singleton.Singleton06@21685669
 *  ================== 性能测试 =====================
 * 懒汉式方法直接加锁花了：7195 millis
 * 懒汉式双重校验锁花了：  2873 millis
 *
 * --------------------------------------- */
