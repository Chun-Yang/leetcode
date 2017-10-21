// The set [1,2,3,…,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
//
// Given n and k, return the kth permutation sequence.
//
// Note: Given n will be between 1 and 9 inclusive.


// https://leetcode.com/problems/permutation-sequence

// time: O(n ^ 2)
import java.util.*;
class Solution {
  public String getPermutation(int n, int k) {
    // get total
    int total = 1;
    for (int i=0; i<n; i++) total *= (i+1);

    // get nums
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i=0; i<n; i++) nums.add(i+1);

    // prepare perm
    ArrayList<String> perm = new ArrayList<>();

    k--;
    for (int i=n; i>=1; i--) {
      total /= i;
      int index = k / total;
      k -= index * total;
      perm.add(Integer.toString(nums.remove(index)));
    }

    return String.join("", perm);
  }
}
