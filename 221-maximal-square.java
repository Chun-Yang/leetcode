// 1 stack: when pop always calculate
// 2 boundary (use boundary in the previous row and the one in the current row)
public class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;

    int maxLength = 0;
    int[][] lengths = new int[m+1][n+1];
    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        if (matrix[i-1][j-1] == '1') {
          lengths[i][j] = Math.min(
              lengths[i-1][j-1],
              Math.min(
                lengths[i][j-1],
                lengths[i-1][j]
                )
              ) + 1;
          maxLength = Math.max(maxLength, lengths[i][j]);
        }
      }
    }
    return maxLength * maxLength;
  }
  // public int maximalSquare(char[][] matrix) {
  //   int m = matrix.length;
  //   if (m == 0) return 0;
  //   int n = matrix[0].length;
  //   if (n == 0) return 0;

  //   // keep an array of heights
  //   int[] heights = new int[n];
  //   int maxLength = 0;

  //   // NOTE: using left and rights
  //   for (int i=0; i<m; i++) {
  //     for (int j=0; j<n; j++) {
  //       heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
  //     }

  //     Deque<Integer> leftStack = new LinkedList<>();
  //     leftStack.push(0);
  //     int[] lefts = new int[n];
  //     lefts[0] = 0;
  //     for (int j=1; j<n; j++) {
  //       while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[j]) {
  //         leftStack.pop();
  //       }
  //       lefts[j] = leftStack.isEmpty() ? 0 : leftStack.peek() + 1;
  //       leftStack.push(j);
  //     }

  //     Deque<Integer> rightStack = new LinkedList<>();
  //     rightStack.push(n-1);
  //     int[] rights = new int[n];
  //     rights[n-1] = n-1;
  //     for (int j=n-2; j>=0; j--) {
  //       while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[j]) {
  //         rightStack.pop();
  //       }
  //       rights[j] = rightStack.isEmpty() ? n - 1 : rightStack.peek() - 1;
  //       rightStack.push(j);
  //     }

  //     for (int j=0; j<n; j++) {
  //       maxLength = Math.max(maxLength, Math.min(heights[j], rights[j] - lefts[j] + 1));
  //     }
  //   }

  //   return maxLength * maxLength;
  // }
}
