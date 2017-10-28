// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one
// and sell one share of the stock), design an algorithm to find the maximum
// profit.
//
// Example 1:
//
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
//
// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//
//
//
// Example 2:
//
// Input: [7, 6, 4, 3, 1]
// Output: 0
//
// In this case, no transaction is done, i.e. max profit = 0.


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
// https://discuss.leetcode.com/topic/19853/kadane-s-algorithm-since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input
// NOTE: this is similar to Kadane's algorithem

// solution1: dp
class Solution {
  public int maxProfit(int[] prices) {
    int buy = Integer.MIN_VALUE;
    int sell = 0;

    for (int price : prices) {
      sell = Math.max(sell, price + buy);
      buy = Math.max(buy, -price);
    }

    return sell;
  }
}
