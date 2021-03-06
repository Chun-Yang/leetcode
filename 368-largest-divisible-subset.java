// Given a set of distinct positive integers, find the largest subset such that
// every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj %
// Si = 0.

// If there are multiple solutions, return any subset is fine.

// Example 1:

// nums: [1,2,3]

// Result: [1,2] (of course, [1,3] will also be ok)
// Example 2:

// nums: [1,2,4,8]

// Result: [1,2,4,8]


// Solution:
// - sort it O(n * log(n))
// - for each value, we count all values before it that can be divided by it
// O(n * n)



















// solution1: Sort, and dp O(n^2)
import java.util.*;

class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> sets = new ArrayList<>();
    List<Integer> largest = new ArrayList<Integer>();;

    for (int i=0; i<nums.length; i++) {
      sets.add(new ArrayList<Integer>());
      for (int j=0; j<i; j++) {
        if (nums[i] % nums[j] == 0 && sets.get(j).size() > sets.get(i).size()) {
          sets.set(i, sets.get(j));
        }
      }
      sets.set(i, new ArrayList<Integer>(sets.get(i)));
      sets.get(i).add(nums[i]);
      if (sets.get(i).size() > largest.size()) largest = sets.get(i);
    }
    return largest;
  }
}

// solution2: Sort dp O(n^2) O(n) space, only save length in first dp, or just
// brutal force. The second run, we get all the numbers that num_largest % num_i = 0
// https://discuss.leetcode.com/topic/49741/easy-understood-java-dp-solution-in-28ms-with-o-n-2-time/2
