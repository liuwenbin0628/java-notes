package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【懒汉式-双重校验锁-线程安全】
 * .             一） 加锁只加了 instance==null 的那一次，
 * .                 后面 instance 不为 null 的时候线程不会阻塞到锁那里，
 * .                 既保证了线程安全性，还不影响程序的性能。
 * .             二） volatile 修饰 instance 是为了禁止JVM的指令重排.
 * .                 instance = new Singleton04()这条语句做了三件事：
 * .                  1 为 instance 分配内存地址；
 * .                  2 初始化 instance；
 * .                  3 将 instance 指向分配的内存地址
 * .                 由于JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。
 * .                 指令重排在单线程环境下不会出现问题，但在多线程环境下会导致一个线程获得还未初始化的实例。
 * .                 例如：线程 T1 执行了 1 和 3，没有来得及执行 2.
 * .                   此时线程 T2 调用getInstance()后发现instance不为空,
 * .                   并直接返回instance,但此时instance还未被初始化.
 * .             三） 构造器私有化，客户端就无法new一个对象，但是可以通过反射调用构造器，
 * .                 这时在构造器内加判断可以避免这种情况
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */

public class Singleton04 {

    private volatile static Singleton04 instance;

    private Singleton04() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized!");
        }
    }

    public static Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
