package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【懒汉式-线程安全】
 * .             缺点：当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，
 * .                  但是instance很可能已经被实例化了。这会让线程阻塞时间过长，影响性能。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 * @ Since      : JDK1.8
 */

public class Singleton03 {

    private static Singleton03 instance;

    private Singleton03() {
    }

    public static synchronized Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
