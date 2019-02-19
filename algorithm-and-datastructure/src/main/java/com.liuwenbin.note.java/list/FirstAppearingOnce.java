package com.liuwenbin.note.java.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Description：字符流中第一个不重复的字符
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class FirstAppearingOnce {

    private int[] counts = new int[256];
    private Queue<Character> fifo = new LinkedList<>();

    public void insert(char c) {
        // 1 做标记
        counts[c]++;
        // 2 把先进先出队列的对头出现两次以上的全部删掉
        while (!fifo.isEmpty()
                && counts[fifo.peek()] > 1) {
            fifo.poll();
        }
    }

    public char findFirstAppearingOnce() {
        return fifo.isEmpty()
                ? '#'
                : fifo.peek();
    }
}
