package com.liuwenbin.notes.java.factory.factory_method;

import com.liuwenbin.notes.java.factory.Fruit;
import com.liuwenbin.notes.java.factory.Orange;

/**
 * @ Description：橘子工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class OrangeFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Orange();
    }
}
