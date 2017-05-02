public class Solution {
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;

    int maxRec = 0;
    int[] heights = new int[n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (matrix[i][j] == '1') heights[j] = heights[j] + 1;
        else heights[j] = 0;
      }
      maxRec = Math.max(maxRec, largestRectangleArea(heights));
    }

    return maxRec;
  }
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int l = heights.length;
    Stack<Integer> lefts = new Stack<Integer>();
    Stack<Integer> lHeights = new Stack<Integer>();

    for (int i=0; i<=l; i++) {
      int h = i == l ? 0 : heights[i];
      int left = i;

      while (!lefts.empty() && h <= lHeights.peek()) {
        left = lefts.pop();
        maxArea = Math.max(maxArea, lHeights.pop() * (i - left));
      }

      lefts.push(left);
      lHeights.push(h);
    }

    return maxArea;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
