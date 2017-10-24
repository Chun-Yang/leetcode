// Given n non-negative integers representing the histogram's bar height where
// the width of each bar is 1, find the area of largest rectangle in the
// histogram.
//
//
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.


// https://leetcode.com/problems/largest-rectangle-in-histogram

// solution1:
// for each end, find the max width for all previous starts
// use a stack to save ascending left boundary indexes
// NOTE: we always push the current one
// especially when the height is same with a previous one, since
// we use the indexes as left boundary(also height when poped out),
// we need to make sure when this thing happens 1 1 3 (all heights),
// we use the index of the second 1 as left boundary

import java.util.*;
class Solution {
  public int largestRectangleArea(int[] height) {
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    for (int end=0; end<=height.length; end++) {
      int endHeight = end == height.length ? 0 : height[end];
      while (!stack.isEmpty() && height[stack.peek()] >= endHeight) {
        int curHeight = height[stack.pop()];
        int start = stack.isEmpty() ? -1 : stack.peek();
        max = Math.max(max, (end - start - 1) * curHeight);
      }
      stack.push(end);
    }
    return max;
  }
}
