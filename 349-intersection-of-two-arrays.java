// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

import java.util.*;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> uniqueNums1 = new HashSet<>();
    for (int num : nums1) uniqueNums1.add(num);
    HashSet<Integer> overlay = new HashSet<>();
    for (int num : nums2) {
      if (uniqueNums1.contains(num)) overlay.add(num);
    }
    int[] overlayInts = new int[overlay.size()];
    int i = 0;
    for (int num : overlay) overlayInts[i++] = num;
    return overlayInts;
  }
}
