package com.liuwenbin.notes.java.factory.factory_method;

import com.liuwenbin.notes.java.factory.Apple;
import com.liuwenbin.notes.java.factory.Fruit;

/**
 * @ Description：苹果工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class AppleFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
