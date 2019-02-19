package com.liuwenbin.notes.java.factory.simple_factory;

import com.liuwenbin.notes.java.factory.Apple;
import com.liuwenbin.notes.java.factory.Banana;
import com.liuwenbin.notes.java.factory.Fruit;
import com.liuwenbin.notes.java.factory.Orange;

/**
 * @ Description：简单水果工厂
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 * @ Since      : JDK1.8
 */

public class FruitFactory {

    /**
     * 工厂创建水果的方法（引入枚举，代码更清晰）
     * <p>
     * 缺点：没有解耦，不符合闭开原则，每次增加水果都要修改该方法
     */
    public Fruit createFruit(FruitType fruitType) {

        switch (fruitType) {
            case APPLE:
                return new Apple();
            case BANANA:
                return new Banana();
            case ORANGE:
                return new Orange();
            default:
                throw new IllegalArgumentException("FruitType Not Supported!");
        }
    }
}
