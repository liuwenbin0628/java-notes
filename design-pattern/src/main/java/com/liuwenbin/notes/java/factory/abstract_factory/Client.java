package com.liuwenbin.notes.java.factory.abstract_factory;

/**
 * @ Description：抽象工厂的客户端
 * .              1 抽象工厂模式创建的是对象家族，
 * .               也就是很多对象而不是一个对象，并且这些对象是相关的
 * .              2 在客户端调用时，创建工厂用的是创建工厂的工厂这个类
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class Client {

    public static void main(String[] args) {

        // 小明条件好，可以吃得起套餐A
        FoodFactory aFactory = FactoryMaker.makeFactory(FactoryType.PACK_A);
        aFactory.createFruit().say();
        aFactory.createMeat().say();

        // 小王条件一般，点了套餐B
        FoodFactory bFactory = FactoryMaker.makeFactory(FactoryType.PACK_B);
        bFactory.createFruit().say();
        bFactory.createMeat().say();

    }
}
/* ---------------- output -------------
 *
 * I am an apple!
 * I am a piece of beef!
 * I am a banana!
 * I am a piece of pork!
 *
 * ----------------------------------- */