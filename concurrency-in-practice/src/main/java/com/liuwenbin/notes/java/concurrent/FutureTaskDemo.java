package com.liuwenbin.notes.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: 刘文斌 2018-11-14
 **/

public class FutureTaskDemo {

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<>(() -> { // 重写了Callable类的call()方法
            int result = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("future task thread is running...");
                Thread.sleep(100);
                result += i;
            }
            return result;
        });
        new Thread(futureTask).start();

        try {
            System.out.println("[ main task is running ]");
            System.out.println("future task result : " + futureTask.get());
            System.out.println("[ main task is over ]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/* ------------------ output: ----------------------
 *
 * [ main task is running ]
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task thread is running...
 * future task result : 45
 * [ main task is over ]
 *
 * ------------------------------------------------- */

