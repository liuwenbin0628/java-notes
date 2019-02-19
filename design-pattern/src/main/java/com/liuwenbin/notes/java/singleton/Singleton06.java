package com.liuwenbin.notes.java.singleton;

/**
 * @ Description：【枚举-线程安全】
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/2
 */

public enum Singleton06 {

    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() // 名字
                + "@" + hashCode();                   // 哈希
    }

}
