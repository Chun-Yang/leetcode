public class Solution {
  public int maxProfit(int[] prices) {
    int maxGain = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int p: prices) {
      minPrice = Math.min(minPrice, p);
      maxGain = Math.max(maxGain, p - minPrice);
    }
    return maxGain;
  }
}
