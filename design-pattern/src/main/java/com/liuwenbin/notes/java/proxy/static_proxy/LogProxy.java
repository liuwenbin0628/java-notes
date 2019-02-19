package com.liuwenbin.notes.java.proxy.static_proxy;

import com.liuwenbin.notes.java.proxy.Subject;
/**
 * @ Description：日志代理
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/23
 * @ Since      : JDK1.8
 */
 
public class LogProxy implements Subject {

    private Subject subject;

    public LogProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void work() {

        // before
        System.out.println(">>>>> start working >>>>>");

        subject.work();

        // after
        System.out.println("<<<<< end working <<<<<");
    }
}
