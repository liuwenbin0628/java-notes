package com.liuwenbin.notes.java.proxy.dynamic_proxy;

import com.liuwenbin.notes.java.proxy.RealSubject;
import com.liuwenbin.notes.java.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * @ Description：动态代理的客户端
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/26
 */

public class Client {

    public static void main(String[] args) {

        // 1 生成委托类
        RealSubject worker = new RealSubject();

        // 2 创建调用处理器对象
        ProxyHandler handler = new ProxyHandler(worker);

        // 3 动态生成代理对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(), // 类加载器
                RealSubject.class.getInterfaces(),  // 要代理的接口
                handler                             // 一个 InvocationHandler 对象
        );

        // 4 通过代理对象，调用方法
        proxySubject.work();
    }
}
/**-------------- output --------------
 *
 * >>>>>>>>> before working >>>>>>>>>
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
 * <<<<<<<<<< after working <<<<<<<<<
 *
 * --------------------------------------- */