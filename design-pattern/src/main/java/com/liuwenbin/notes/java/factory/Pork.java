package com.liuwenbin.notes.java.factory;

/**
 * @ Description：猪肉
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 * @ Since      : JDK1.8
 */
 
public class Pork implements Meat {

    @Override
    public void say() {
        System.out.println("I am a piece of pork!");
    }

}
