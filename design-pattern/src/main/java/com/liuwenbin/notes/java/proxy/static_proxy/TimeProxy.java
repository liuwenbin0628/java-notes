package com.liuwenbin.notes.java.proxy.static_proxy;

import com.liuwenbin.notes.java.proxy.Subject;
/**
 * @ Description：时间代理
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/23
 * @ Since      : JDK1.8
 */
 
public class TimeProxy implements Subject {

    private Subject subject;

    public TimeProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void work() {

        // 起始时间
        long startTime = System.currentTimeMillis();

        // 工作
        subject.work();

        // 结束时间
        long endTime = System.currentTimeMillis();

        // 计算工作时间
        System.out.println("working time is [ " + (endTime - startTime) + " ] millis");

    }
}
