package com.liuwenbin.notes.java.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description：具体的被观察者
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/17
 * @ Since      : JDK1.8
 */

public class ConcreteSubject implements Subject {

    /**
     * 存储了所有订阅了主题的观察者
     */
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String message) {
        // 遍历观察者链表，调用每个观察者自己的通知方法
        observerList.forEach(observer -> observer.update(message));
    }
}
