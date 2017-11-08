// Given a list of non negative integers, arrange them such that they form the largest number.
//
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
// Note: The result may be very large, so you need to return a string instead of an integer.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


// https://leetcode.com/problems/largest-number

// NOTE: what if the array is [0, 0, 0], []

// use simple cases:
// [1,2,3,4,5] -> 54321
// [10, 11] -> 1110
// [10, 1] -> 110
// [12, 1] -> 121
// [11, 1] -> 111
// [111112, 1] -> 1111121
// [124, 12444] -> 12444124
// compare two string AB and BA
// Convert interger to string
// Sort array by digits
// join them together
