package com.liuwenbin.note.java.search;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ Description：找数据流的中位数
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/4
 */

public class MedianFinder {

    /**
     * 小顶堆,
     * 用来存大元素
     */
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    /**
     * 大顶堆，
     * 用来存小元素
     */
    private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);


    /**
     * 添加元素
     */
    public void addNum(int num) {

        // 1 先将元素放入大顶堆
        max.offer(num);

        // 2 将大顶堆的最大元素放入小顶堆
        min.add(max.poll());

        // 3 使两个堆的数量： 一致 || 大顶堆比小顶堆多一个
        if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    /**
     * 找中位数
     */
    public double findMedian() {
        // 这边就很好理解了
        return max.size() == min.size()
                // 偶数，中位数就是平均值
                ? (max.peek() + min.peek()) / 2.0
                // 奇数，中位数就是中间值
                : max.peek();

    }
}
