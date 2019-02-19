package com.liuwenbin.note.java.dp;

/**
 * @ Description：给出每天的股价构成的股价数组，
 * .             可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/9
 */

public class BuySellStock {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // 记录当前最小的股价
        int sofarMin = prices[0];
        // 记录当前最大盈利
        int maxProfit = 0;

        for (int price : prices) {
            if (price > sofarMin) {
                // 当天股价比之前最低的股价高，可以尝试是否更新最大盈利
                // 更新逻辑：最低点买进，当天卖出，这个盈利是否大于已有的最大盈利
                maxProfit = Math.max(maxProfit, price - sofarMin);
            } else {
                // 当天股价比之前最低股价低，则不可能出现新的最大盈利
                // 但是需要更新最低股价变量
                sofarMin = price;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
