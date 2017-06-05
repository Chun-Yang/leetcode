public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[] required = new int[n];

    required[n-1] = Math.max(-dungeon[m-1][n-1], 0);

    for (int j=n-2; j>=0; j--) {
      required[j] = Math.max(required[j+1] - dungeon[m-1][j], 0);
    }

    for (int i=m-2; i>=0; i--) {
      required[n-1] = Math.max(required[n-1] - dungeon[i][n-1], 0);
      for (int j=n-2; j>=0; j--) {
        required[j] = Math.max(
            Math.min(required[j], required[j+1]) - dungeon[i][j],
            0
            );
      }
    }

    return required[0] + 1;
  }
  // public int calculateMinimumHP(int[][] dungeon) {
  //   int m = dungeon.length;
  //   int n = dungeon[0].length;
  //   int[][] required = new int[m][n];
  //   int right;
  //   int down;
  //   int picked;

  //   for (int i=m-1; i>=0; i--) {
  //     for (int j=n-1; j>=0; j--) {
  //       down  = i == m-1 ? Integer.MAX_VALUE : required[i+1][j];
  //       right = j == n-1 ? Integer.MAX_VALUE : required[i][j+1];
  //       picked = i == m-1 && j == n-1 ? 0 : Math.min(down, right);
  //       required[i][j] = Math.max(picked - dungeon[i][j], 0);
  //     }
  //   }

  //   return required[0][0] + 1;
  // }
}
