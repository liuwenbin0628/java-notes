package com.liuwenbin.notes.java.communicate;

/**
 * @ Description：
 * @ Author     ：liuwenbin
 * @ Date       ：2018/11/14
 * @ Since      : JDK1.8
 */

public class JoinDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread start...");

        // 1 新建线程son
        ThreadSon threadSon = new ThreadSon("son");
        // 2 启动线程son
        threadSon.start();
        try {
            // 3 将线程son加到主线程main中
            threadSon.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread finish...");
    }

    static class ThreadSon extends Thread {
        public ThreadSon(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " thread start...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " thread finish...");
        }
    }
}
/**
 * ------------------ output: ----------------------
 *
 * main thread start...
 * son thread start...
 * son thread finish...
 * main thread finish...
 *
 * --------------------------------------------------
 */



