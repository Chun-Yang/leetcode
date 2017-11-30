// Given an integer n, count the total number of digit 1 appearing in all
// non-negative integers less than or equal to n.
//
//
// For example:
// Given n = 13,
// Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.


// https://leetcode.com/problems/number-of-digit-one

// solution1: for each digit, we count all numbers where that digit is 1
// - left steaks(0,1,other) + right when left is at maximum(0,1,other)
// https://discuss.leetcode.com/topic/18054/4-lines-o-log-n-c-java-python
