package com.liuwenbin.notes.java.factory.factory_method;

import com.liuwenbin.notes.java.factory.Banana;
import com.liuwenbin.notes.java.factory.Fruit;

/**
 * @ Description：香蕉工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class BananaFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Banana();
    }
}
