// Problem Description:

// Given an array of n integers nums and a target, find the number of index
// triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
// nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]
// Follow up:
// Could you solve it in O(n^2) runtime?

// solution1: sort + two pointers
// the reason sort works is that ANY triplet satisfy i < j < k
// even the array is sorted, we can always select i j k for any triplet
// so that i < j < k
