// You are given two integer arrays nums1 and nums2 sorted in ascending order and
// an integer k.

// Define a pair (u,v) which consists of one element from the first array and one
// element from the second array.

// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

// Example 1:
// Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

// Return: [1,2],[1,4],[1,6]

// The first 3 pairs are returned from the sequence:
// [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:
// Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

// Return: [1,1],[1,1]

// The first 2 pairs are returned from the sequence:
// [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// Example 3:
// Given nums1 = [1,2], nums2 = [3],  k = 3

// Return: [1,3],[2,3]

// All possible pairs are returned from the sequence:
// [1,3],[2,3]

import java.util.*;

class Solution {
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if (k == 0 || nums1.length == 0 || nums2.length == 0) return new ArrayList<>();

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] p1, int[] p2) {
        return p1[0] + p1[1] - p2[0] - p2[1];
      }
    });
    for (int i=0; i<Math.min(nums1.length, k); i++) pq.offer(new int[]{ nums1[i], nums2[0], 0 });

    List<int[]> pairs = new ArrayList<>();
    for (int i=0; i<k; i++) {
      int[] pair = pq.poll();
      pairs.add(new int[]{ pair[0], pair[1] });
      if (pair[2] < nums2.length - 1) {
        pq.offer(new int[]{ pair[0], nums2[pair[2] + 1], pair[2] + 1 });
      }
      if (pq.isEmpty()) break;
    }

    return pairs;
  }
}
