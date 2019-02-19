package com.liuwenbin.notes.java.factory.abstract_factory;

import com.liuwenbin.notes.java.factory.Fruit;
import com.liuwenbin.notes.java.factory.Meat;

/**
 * @ Description：抽象的食物工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */

public interface FoodFactory {

    Fruit createFruit();

    Meat createMeat();
}
