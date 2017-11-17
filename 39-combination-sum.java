// Given a set of candidate numbers (C) (without duplicates) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//
// The same repeated number may be chosen from C unlimited number of times.
//
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [2, 3, 6, 7] and target 7,
// A solution set is:
// [
// [7],
// [2, 2, 3]
// ]


// https://leetcode.com/problems/combination-sum

// solution1: dp (bottom to top)
// 1: 1
// 2: 1 1, 2
// 3: 1 1 1, 1 2, 3
// 4: 1 1 1 1, 1 1 2, 1 3, 2 2
// n is the target
// time O(n ^ 2)

// solution2: dfs + backtracking + cache (top to bottom)
// Solution3: dfs + backtracking
