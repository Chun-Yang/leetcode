// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

import java.util.*;

class Solution {
  public int maxProfit(int[] prices) {
    int[] buys = new int[2];
    Arrays.fill(buys, Integer.MIN_VALUE);
    int[] sells = new int[2];
    for (int price : prices) {
      sells[1] = Math.max(buys[1] + price, sells[1]);
      buys[1] = Math.max(sells[0] - price, buys[1]);
      sells[0] = Math.max(buys[0] + price, sells[0]);
      buys[0] = Math.max(- price, buys[0]);
    }
    return sells[1];
  }
}
