package com.liuwenbin.notes.java.observer;

/**
 * @ Description：抽象被观察者
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/17
 * @ Since      : JDK1.8
 */

public interface Subject {

    /**
     * 增加订阅者
     */
    void attach(Observer observer);

    /**
     * 删除订阅者
     */
    void detach(Observer observer);

    /**
     * 通知订阅者消息的变更
     */
    void notify(String message);

}
