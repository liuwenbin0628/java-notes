package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【静态内部类-线程安全】
 * .              当Singleton05被加载时，静态内部类InstanceHolder不会被加载进内存
 * .              只有调用getInstance()时，InstanceHolder才会被加载,
 * .              此时初始化INSTANCE实例，且JVM能确保INSTANCE只被实例化一次。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/2
 */

public class Singleton05 {

    private Singleton05() {
    }

    private static class InstanceHolder {
        private static final Singleton05 INSTANC
                = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return InstanceHolder.INSTANC;
    }

}
