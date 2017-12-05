// Numbers can be regarded as product of its factors. For example,

// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.

// Note:
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.

// solution1:
// dfs, we can use back tracking
// 2 to sqrt(n), next one >= current one
// e.g.
// 8 = 2 x 4
//   = 2 x 2 x 2
// 16 = 2 x 8
//    = 2 x 2 x 4
//    = 2 x 2 x 2 x 2
//    = 4 x 4
