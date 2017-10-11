// Implement next permutation, which rearranges numbers into the
// lexicographically next greater permutation of numbers.
//
//
// If such arrangement is not possible, it must rearrange it as the lowest
// possible order (ie, sorted in ascending order).
//
//
// The replacement must be in-place, do not allocate extra memory.
//
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1


// https://leetcode.com/problems/next-permutation

// 1,2,3 -> 1,3,2
// 1,3,2 -> 2,1,3
// 1,2,6,5,4,3 -> 1,3,2,3,5,6
// Solution1:
// - from right to left, get the boundary of assending sequence
// - if boundary is -1, we reverse
// - otherwise, use the smallest one that is larger than the current one
//   swap them and reverse the assending sequence
