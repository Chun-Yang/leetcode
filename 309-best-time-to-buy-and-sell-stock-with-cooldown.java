// Say you have an array for which the ith element is the price of a given
// stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many
// transactions as you like (ie, buy one and sell one share of the stock
// multiple times) with the following restrictions:

// You may not engage in multiple transactions at the same time (ie, you must
// sell the stock before you buy again). After you sell your stock, you cannot
// buy stock on next day. (ie, cooldown 1 day) Example:

// prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell, cooldown,
// buy, sell]


// Solution 1: my solution, each var represent the max profit that end with the
// state after an action
// class Solution {
//   public int maxProfit(int[] prices) {
//     int buy = Integer.MIN_VALUE;
//     int sell = 0;
//     int hold = Integer.MIN_VALUE;
//     int empty = 0;

//     for (int price : prices) {
//       int b = empty - price;
//       int s = Math.max(hold, buy) + price;
//       int h = Math.max(hold, buy);
//       int e = Math.max(empty, sell);
//       buy = b;
//       sell = s;
//       hold = h;
//       empty = e;
//     }

//     return Math.max(Math.max(buy, sell), Math.max(hold, empty));
//   }
// }

// Solution 2: each var represents the max profit that ends with
// (buy or rest)
// (sell or rest)
// (rest)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/

class Solution {
  public int maxProfit(int[] prices) {
    int buy = Integer.MIN_VALUE;
    int sell = 0;
    int rest = 0;
    int b;
    int s;
    int r;
    for (int num : prices) {
      b = Math.max(buy, rest - num);
      s = Math.max(sell, buy + num);
      r = Math.max(sell, rest);
      buy = b;
      sell = s;
      rest = r;
    }
    return Math.max(rest, sell);
  }
}
