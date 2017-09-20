// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.

// Every time you guess wrong,
// I'll tell you whether the number I picked is higher or lower.

// However, when you guess a particular number x, and you guess wrong, you pay $x.
// You win the game when you guess the number I picked.

// Example:

// n = 10, I pick 8.

// First round:  You guess 5, I tell you that it's higher. You pay $5.
// Second round: You guess 7, I tell you that it's higher. You pay $7.
// Third round:  You guess 9, I tell you that it's lower. You pay $9.

// Game over. 8 is the number I picked.

// You end up paying $5 + $7 + $9 = $21.
// Given a particular n ≥ 1,
// find out how much money you need to have to guarantee a win.

class Solution {
  public int getMoneyAmount(int n) {
    int[][] amounts = new int[n + 2][n + 2];
    for (int length=2; length<=n; length++) {
      for (int from=1; from + length - 1 <= n; from++) {
        int to = from + length - 1;
        amounts[from][to] = Integer.MAX_VALUE;
        for (int selected=from; selected<=to; selected++) {
          amounts[from][to] = Math.min(
            amounts[from][to],
            selected + Math.max(amounts[from][selected-1], amounts[selected+1][to])
          );
        }
      }
    }
    return amounts[1][n];
  }
}
