package com.liuwenbin.notes.java.threadPool;

import java.util.concurrent.*;

/**
 * @ Description：
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/2
 * @ Since      : JDK1.8
 */
 
public class ThreadPoolExecutorDemo {


    private ExecutorService threadPool = new ThreadPoolExecutor(
            10, // corePoolSize：核心池的大小
            100, // maximumPoolSize：线程池最大线程数
            0, // keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止
            TimeUnit.MILLISECONDS, // keepAliveTime的时间单位
            new LinkedBlockingDeque<>(1024), // workQueue：一个阻塞队列，用来存储等待执行的任务
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return null;
                }
            },
            new ThreadPoolExecutor.AbortPolicy() // handler：表示当拒绝处理任务时的策略
    );

    public static void main(String[] args) {


    }

}
