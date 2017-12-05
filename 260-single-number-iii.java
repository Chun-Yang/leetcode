// Given an array of numbers nums, in which exactly two elements appear only
// once and all the other elements appear exactly twice. Find the two elements
// that appear only once.
//
//
// For example:
//
//
// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//
// Note:
//
// The order of the result is not important.
// So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity.
// Could you implement it using only constant space complexity?

// https://leetcode.com/problems/single-number-iii

// NOTE:
// https://discuss.leetcode.com/topic/25382/sharing-explanation-of-the-solution
// for bit i, the two values are different(one is 1, the other is 0)
// all the numbers can be partitioned into two groups according to their bits at location i.
// the first group consists of all numbers whose bits at i is 0.
// the second group consists of all numbers whose bits at i is 1.
