// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such
// that you cannot load all elements into the memory at once?

import java.util.*;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> uniqueNums1 = new HashMap<>();
    for (int num : nums1) uniqueNums1.put(num, uniqueNums1.getOrDefault(num, 0) + 1);
    HashMap<Integer, Integer> overlay = new HashMap<>();
    for (int num : nums2) {
      if (uniqueNums1.containsKey(num)) {
        overlay.put(num, overlay.getOrDefault(num, 0) + 1);
        uniqueNums1.put(num, uniqueNums1.get(num) - 1);
        if (uniqueNums1.get(num) == 0) uniqueNums1.remove(num);
      }
    }
    int count = 0;
    for (int num : overlay.keySet()) count += overlay.get(num);

    int[] overlayInts = new int[count];
    int i = 0;
    for (int num : overlay.keySet()) {
      for (int j=0; j<overlay.get(num); j++) overlayInts[i++] = num;
    }
    return overlayInts;
  }
}
