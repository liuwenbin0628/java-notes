package com.liuwenbin.notes.java.observer;

/**
 * @ Description：用java8重构,代码更简洁
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/20
 * @ Since      : JDK1.8
 */
 
public class Client_Java8 {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();

        subject.attach((String message) ->
            System.out.println("o1" + message)
        );
        subject.attach((String message) ->
            System.out.println("o2" + message)
        );
        subject.attach((String message) ->
            System.out.println("o3" + message)
        );

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