package com.liuwenbin.notes.java.factory.simple_factory;

/**
 * @ Description：简单工厂的客户端
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 * @ Since      : JDK1.8
 */

public class Client {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();

        factory.createFruit(FruitType.APPLE)
                .say();

        factory.createFruit(FruitType.BANANA)
                .say();

        factory.createFruit(FruitType.ORANGE)
                .say();
    }
}
/*---------------- output -------------
 *
 * I am an apple!
 * I am a banana!
 * I am an orange!
 *
 * ----------------------------------- */