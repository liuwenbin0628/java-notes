package com.liuwenbin.notes.java.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description：模拟堆内存溢出
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/23
 */
 
public class HeapOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        while (true) {
            list.add("a");
        }
    }
}

/* --------------------- output ----------------------*
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3210)
 * 	at java.util.Arrays.copyOf(Arrays.java:3181)
 * 	at java.util.ArrayList.grow(ArrayList.java:265)
 * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
 * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
 * 	at java.util.ArrayList.add(ArrayList.java:462)
 * 	at com.liuwenbin.notes.java.memory.HeapOOM.main(HeapOOM.java:18)
 *
 * ------------------------------------------------ */


