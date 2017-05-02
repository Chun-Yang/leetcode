import java.util.Stack;

public class Solution {
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
    // assert s.largestRectangleArea(new int[] {2, 1}) == 2;
    // assert s.largestRectangleArea(new int[] {1, 1}) == 2;
    assert s.largestRectangleArea(new int[] {2,1,5,6,2,3}) == 10;
  }
}
