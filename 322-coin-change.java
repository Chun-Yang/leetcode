class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount < 0) return -1;

    int[] counts = new int[amount + 1];
    Arrays.fill(counts, -1);
    counts[0] = 0;

    for (int i=1; i<=amount; i++) {
      for (int j=0; j<coins.length; j++) {
        if (i - coins[j] >= 0 && counts[i - coins[j]] != -1 && (counts[i] == -1 || counts[i - coins[j]] + 1 < counts[i])) {
          counts[i] = counts[i - coins[j]] + 1;
        }
      }
    }

    return counts[amount];
  }
}
