package com.liuwenbin.notes.java.observer;

/**
 * @ Description：客户端，测试观察者模式
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/17
 * @ Since      : JDK1.8
 */

public class Client {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者
        ConcreteObserver observer1 = new ConcreteObserver("o1");
        ConcreteObserver observer2 = new ConcreteObserver("o2");
        ConcreteObserver observer3 = new ConcreteObserver("o3");

        // 订阅主题
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        // 通知观察者
        subject.notify("主题更新了！");

    }
}
/* ------------------ output: ----------------------
 *
 * o1 : 主题更新了！
 * o2 : 主题更新了！
 * o3 : 主题更新了！
 *
 * ------------------------------------------------ */
