package com.liuwenbin.notes.java.proxy.dynamic_proxy;

import com.liuwenbin.notes.java.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Description：调用处理器
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/26
 * @ Since      : JDK1.8
 */

public class ProxyHandler implements InvocationHandler {

    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println(">>>>>>>>> before working >>>>>>>>>");

        Object result = method.invoke(subject, args);

        System.out.println("<<<<<<<<<< after working <<<<<<<<<");

        return result;
    }
}
