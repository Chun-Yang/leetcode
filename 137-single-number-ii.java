// Given an array of integers, every element appears three times except for one,
// which appears exactly once. Find that single one.
//
//
//
// Note:
// Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?


// https://leetcode.com/problems/single-number-ii
// 0 -> 0, 0
// 1 -> 0, 1
// 2 -> 1, 1
// 3 -> 0, 0
// second = (first & num) ^ second
// first = (first | num) ^ preSecond
// probably need a true/fasle table
