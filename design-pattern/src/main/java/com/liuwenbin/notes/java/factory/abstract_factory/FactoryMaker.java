package com.liuwenbin.notes.java.factory.abstract_factory;

/**
 * @ Description：创建工厂的工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/2
 */

public class FactoryMaker {

    public static FoodFactory makeFactory(FactoryType factoryType) {

        switch (factoryType) {
            case PACK_A:
                return new PackAFactory();
            case PACK_B:
                return new PackBFactory();
            default:
                throw new IllegalArgumentException("FactoryType Not Supported!");
        }
    }
}
