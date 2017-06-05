// TODO
// 1. figure out the other way (not using buy and sell)
// 2. handle when k >= n/2
public class Solution {
  public int maxProfit(int k, int[] prices) {
    if (k == 0) return 0;

    if (k >= prices.length / 2) {
      int profit = 0;
      for (int i=1; i<prices.length; i++) {
        profit += Math.max(0, prices[i] - prices[i-1]);
      }
      return profit;
    }

    int[] buys = new int[k];
    int[] sells = new int[k];
    Arrays.fill(buys, Integer.MIN_VALUE);
    for (int price : prices) {
      for (int i=k-1; i>=0; i--) {
        sells[i] = Math.max(sells[i], buys[i] + price);
        if (i == 0) buys[i] = Math.max(buys[i], -price);
        else buys[i] = Math.max(buys[i], sells[i-1] - price);
      }
    }
    return sells[k-1];
  }
}
