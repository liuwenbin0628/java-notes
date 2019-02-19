package com.liuwenbin.notes.java.factory.abstract_factory;

import com.liuwenbin.notes.java.factory.Banana;
import com.liuwenbin.notes.java.factory.Fruit;
import com.liuwenbin.notes.java.factory.Meat;
import com.liuwenbin.notes.java.factory.Pork;

/**
 * @ Description：套餐B的工厂方法（香蕉+猪肉）
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class PackBFactory implements FoodFactory {

    @Override
    public Fruit createFruit() {
        return new Banana();
    }

    @Override
    public Meat createMeat() {
        return new Pork();
    }
}
