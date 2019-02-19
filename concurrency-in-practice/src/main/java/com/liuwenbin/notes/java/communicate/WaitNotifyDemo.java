package com.liuwenbin.notes.java.communicate;

/**
 * @ Description：两个线程交替打印奇偶数
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 * @ Since      : JDK1.8
 */

public class WaitNotifyDemo {

    private static int count = 1;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (LOCK) {
                while (count <= 20) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                    } else {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (LOCK) {
                while (count <= 20) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                    } else {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
/**
 * --------------- output -------------
 * <p>
 * Thread-0 : 1
 * Thread-1 : 2
 * Thread-0 : 3
 * Thread-1 : 4
 * Thread-0 : 5
 * Thread-1 : 6
 * Thread-0 : 7
 * Thread-1 : 8
 * Thread-0 : 9
 * Thread-1 : 10
 * Thread-0 : 11
 * Thread-1 : 12
 * Thread-0 : 13
 * Thread-1 : 14
 * Thread-0 : 15
 * Thread-1 : 16
 * Thread-0 : 17
 * Thread-1 : 18
 * Thread-0 : 19
 * Thread-1 : 20
 * <p>
 * -------------------------------
 */
