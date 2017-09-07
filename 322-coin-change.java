// You are given coins of different denominations and a total amount of money
// amount. Write a function to compute the fewest number of coins that you need to
// make up that amount. If that amount of money cannot be made up by any
// combination of the coins, return -1.

// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)

// Example 2:
// coins = [2], amount = 3
// return -1.

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
