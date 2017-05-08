public class Solution {
  public int maxProfit(int[] prices) {
    int maxGain = 0;
    int length = prices.length;
    for (int i=1; i<length; i++) {
      maxGain += Math.max(0, prices[i] - prices[i-1]);
    }
    return maxGain;
  }
}
