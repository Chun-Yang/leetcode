// Given an array of n integers where n > 1, nums, return an array output such
// that output[i] is equal to the product of all the elements of nums except
// nums[i].
//
// Solve it without division and in O(n).
//
// For example, given [1,2,3,4], return [24,12,8,6].
//
// Follow up:
// Could you solve it with constant space complexity? (Note: The output array
// does not count as extra space for the purpose of space complexity analysis.)


// https://leetcode.com/problems/product-of-array-except-self

// solution1: use two arrays, one for prefix mutiplication, one for surfix
// solution2:
// initialize the result array with surfix multiplication,
// use one number to keep track of prefix multiplication
// Or we can do solution1 but using two pass and keep track of prefix or surfix
// respectively
