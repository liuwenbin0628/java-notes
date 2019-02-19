package com.liuwenbin.notes.java.proxy.static_proxy;

import com.liuwenbin.notes.java.proxy.RealSubject;

/**
 * @ Description：静态代理的客户端
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/23
 * @ Since      : JDK1.8
 */
 
public class Client {

    public static void main(String[] args) {

        // 委托类
        RealSubject worker = new RealSubject();

        // 统计时间的代理
        TimeProxy timeProxy = new TimeProxy(worker);

        // 日志代理
        LogProxy logProxy = new LogProxy(timeProxy);

        logProxy.work();
    }
}
/* ----------------- output ----------------------
 *
 * >>>>> start working >>>>>
 * doing the 1st thing
 * doing the 2st thing
 * doing the 3st thing
 * doing the 4st thing
 * doing the 5st thing
 * doing the 6st thing
 * doing the 7st thing
 * doing the 8st thing
 * doing the 9st thing
 * doing the 10st thing
 * doing the 11st thing
 * doing the 12st thing
 * doing the 13st thing
 * doing the 14st thing
 * doing the 15st thing
 * doing the 16st thing
 * doing the 17st thing
 * doing the 18st thing
 * doing the 19st thing
 * doing the 20st thing
 * doing the 21st thing
 * doing the 22st thing
 * doing the 23st thing
 * doing the 24st thing
 * doing the 25st thing
 * doing the 26st thing
 * doing the 27st thing
 * doing the 28st thing
 * doing the 29st thing
 * working time is [ 102 ] millis
 * <<<<< end working <<<<<
 *
 * ------------------------------------------- */
