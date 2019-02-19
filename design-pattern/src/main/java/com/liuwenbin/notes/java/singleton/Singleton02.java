package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【饿汉式-线程安全】
 * .              缺点：该类可能不需要被实例化，这时就浪费了资源
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 * @ Since      : JDK1.8
 */

public class Singleton02 {

    private static final Singleton02 INSTANCE = new Singleton02();

    private Singleton02() {}

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

}
