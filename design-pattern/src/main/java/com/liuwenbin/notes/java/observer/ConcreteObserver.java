package com.liuwenbin.notes.java.observer;

/**
 * @ Description：具体观察类
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/17
 * @ Since      : JDK1.8
 */

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " : " + message);
    }
}
