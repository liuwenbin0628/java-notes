package com.liuwenbin.notes.java.memory;

/**
 * @ Description：模拟栈内存溢出
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/23
 */

public class StackSOF {

    private int stackLength = 0;

    public void stackLeakTest() {
        stackLength++;
        stackLeakTest();
    }

    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();

        try {
            stackSOF.stackLeakTest();
        } catch (Throwable e) {
            System.out.println("Stack Length : " + stackSOF.stackLength);
            throw e;
        }
    }
}
/* ---------------------- output ------------------------- *
 *
 * Stack Length : 19379
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	at com.liuwenbin.notes.java.memory.StackSOF.stackLeakTest(StackSOF.java:15)
 * 	...
 *
 *
 * -------------------------------------------------------- */
