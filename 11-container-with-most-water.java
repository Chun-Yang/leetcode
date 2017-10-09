// Given n non-negative integers a1, a2, ..., an, where each represents a point
// at coordinate (i, ai). n vertical lines are drawn such that the two
// endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
// with x-axis forms a container, such that the container contains the most
// water.
//
// Note: You may not slant the container and n is at least 2.


// https://leetcode.com/problems/container-with-most-water

class Solution {
  public int maxArea(int[] height) {
    int n = height.length;
    int lo = 0;
    int hi = n - 1;
    int area = 0;

    while (lo < hi) {
      area = Math.max(area, (hi - lo) * Math.min(height[lo], height[hi]));
      if (height[lo] > height[hi]) hi--;
      else lo++;
    }

    return area;
  }
}
