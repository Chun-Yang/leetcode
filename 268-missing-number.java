// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
// find the one that is missing from the array.
//
//
// For example,
// Given nums = [0, 1, 3] return 2.
//
//
//
// Note:
// Your algorithm should run in linear runtime complexity. Could you implement
// it using only constant extra space complexity?

// https://leetcode.com/problems/missing-number

// solution1: xor
// xor 0...n and xor all numbers in the array
// optimization: find the xor faster?
// 0
// 1
// 10
// 11
// 100
// 101
// (num / 2) % 2 for the first digit
// (num / 4) % 2 for the second digit
// ...
