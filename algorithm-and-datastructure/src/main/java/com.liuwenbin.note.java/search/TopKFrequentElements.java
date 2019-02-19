package com.liuwenbin.note.java.search;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Description：出现频率最高的k个元素
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/13
 */

public class TopKFrequentElements {

    /**
     * 思路 桶排序
     */
    public List<Integer> find(int[] a, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        // 1 每个数的频率统计在hashmap里面
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // 2 建桶
        List<Integer>[] bucket = new ArrayList[a.length + 1];

        for (int key : freq.keySet()) {

            // 2.1 key出现的频率
            int f = freq.get(key);

            // 2.2 初始化
            if (bucket[f] == null)
                bucket[f] = new ArrayList<>();

            // 2.3 把频率为f的key都放在这个桶里
            bucket[f].add(key);
        }

        List<Integer> res = new ArrayList<>();

        // 3 从后往前遍历桶（后面的频率高，是我们想找的）
        for (int i = bucket.length - 1;
             i >= 0 && res.size() < k;
             i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;

    }
}
