// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the
// array's size.

// solution1: save counter and use quick sort
// solution2: bucket sort
// create n + 1(0, ..., n) buckets, i bucket contains all nums that has count of i
// iterate from back to front and append it to an array
import java.util.*;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }

    ArrayList<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>();
    // NOTE: the following will result in a warning on type
    // LinkedList<Integer>[] buckets = new LinkedList[n+1];
    for (int i=0; i<=nums.length; i++) {
      buckets.add(new LinkedList<Integer>());
    }

    for (int num : counter.keySet()) {
      buckets.get(counter.get(num)).add(num);
    }

    List<Integer> topk = new LinkedList<Integer>();

    for (int i=nums.length; i>0; i--) {
      for (int num : buckets.get(i)) {
        if (topk.size() == k) return topk;
        topk.add(num);
      }
    }

    return topk;
  }
}
