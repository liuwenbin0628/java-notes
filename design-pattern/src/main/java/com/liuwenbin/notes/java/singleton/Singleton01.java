package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【懒汉式-线程不安全】
 * .             优点: 私有静态变量instance被延迟实例化，
 * .                  即如果没有用到该类，就不会实例化instance，节约了资源。
 * .             缺点：高并发情况下多个线程能够同时进入if(instance == null),且此时instance为null，
 * .                  则会有多个线程执行instance = new Singleton01()，导致实例化多次instance
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */

public class Singleton01 {

    private static Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}
