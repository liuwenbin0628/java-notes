package com.liuwenbin.notes.java.producer_consumer;


/**
 * @ Description：wait()和notify()方法的实现生产者消费者模型
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/20
 */

public class Demo1 {

    private static int COUNT = 0;
    private static final int CAPACITY = 10;
    private static String LOCK = "lock";

    /**
     * 生产者
     */
    public class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (COUNT == CAPACITY) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    COUNT++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前共有：" + COUNT);
                    LOCK.notifyAll();
                }
            }
        }
    }

    /**
     * 消费者
     */
    public class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (COUNT == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    COUNT--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前共有：" + COUNT);
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();

        for (int i = 0; i < 5; i++) {
            new Thread(demo.new Producer()).start();
            new Thread(demo.new Consumer()).start();
        }
    }


}
