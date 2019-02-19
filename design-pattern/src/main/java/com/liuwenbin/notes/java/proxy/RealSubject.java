package com.liuwenbin.notes.java.proxy;

import com.liuwenbin.notes.java.proxy.Subject;

import java.util.stream.IntStream;

/**
 * @ Description：被代理类
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/23
 * @ Since      : JDK1.8
 */

public class RealSubject implements Subject {

    @Override
    public void work() {

        // 生成一个10到40的随机数
        int count = (int) (Math.random() * 30) + 10;

        // 执行count次
        IntStream.range(1, count + 1).forEach(i -> System.out.println("doing the " + i + "st thing"));
    }
}
