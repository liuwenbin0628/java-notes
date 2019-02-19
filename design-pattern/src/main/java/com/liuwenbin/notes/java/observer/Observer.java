package com.liuwenbin.notes.java.observer;

/**
 * @ Description：抽象观察者
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/17
 * @ Since      : JDK1.8
 */

public interface Observer {

    /**
     * 更新消息
     */
    void update(String message);
}
