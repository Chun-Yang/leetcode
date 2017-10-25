// Given a collection of integers that might contain duplicates, nums,
// return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
//
// For example,
// If nums = [1,2,2], a solution is:
//
//
//
// [
// [2],
// [1],
// [1,2,2],
// [2,2],
// [1,2],
// []
// ]


// https://leetcode.com/problems/subsets-ii

// solution1:
// sort it and dfs, each children of same parent are different
// [1,2,2,3]
// []
// 1    2     3
// 2 3  2 3
// 2    3
// 3
