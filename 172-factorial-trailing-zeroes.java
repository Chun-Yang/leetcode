// Given an integer n, return the number of trailing zeroes in n!.
//
// Note: Your solution should be in logarithmic time complexity.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


// https://leetcode.com/problems/factorial-trailing-zeroes

// solution1 find pattern
// n        value       zeros
// 0        1           0
// 1        1           0
// 2        2           0
// ...
// 5        120         1
// ...
// 10                   2
// we should count the 5s in all factors
// - for each i, get the # of 5s
// O(n)
// - pattern
// 5    1
// 10   1
// 15   1
// 20   1
// 25   2
//
// n % 5 # of 5s
// n % 25 # of 25s
// n % 125 # of 125s
// increase expo, until n is smaller than that value
// overflow: long value or other ways
// ( new value / 5 should equal to the previous value )
