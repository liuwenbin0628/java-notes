package com.liuwenbin.notes.java.factory.abstract_factory;

import com.liuwenbin.notes.java.factory.Apple;
import com.liuwenbin.notes.java.factory.Beef;
import com.liuwenbin.notes.java.factory.Fruit;
import com.liuwenbin.notes.java.factory.Meat;

/**
 * @ Description：套餐A的工厂方法（苹果+牛肉）
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class PackAFactory implements FoodFactory {

    @Override
    public Fruit createFruit() {
        return new Apple();
    }

    @Override
    public Meat createMeat() {
        return new Beef();
    }
}
