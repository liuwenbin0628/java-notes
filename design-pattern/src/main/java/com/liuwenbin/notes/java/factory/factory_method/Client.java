package com.liuwenbin.notes.java.factory.factory_method;

/**
 * @ Description：工厂方法客户端
 * .              优点：相对于简单工厂，工厂方法做到了：
 * .                   1）解耦
 * .                   2）符合开闭原则(OCP)
 * .              缺点：另一种问题没解决，
 * .                   假如是一组产品，则每次都需要new所有的产品的工厂方法
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/1
 */
 
public class Client {

    public static void main(String[] args) {

        new AppleFactory()
                .createFruit()
                .say();

        new BananaFactory()
                .createFruit()
                .say();

        new OrangeFactory()
                .createFruit()
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
