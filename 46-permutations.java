// Given a collection of distinct numbers, return all possible permutations.
//
//
//
// For example,
// [1,2,3] have the following permutations:
// [
// [1,2,3],
// [1,3,2],
// [2,1,3],
// [2,3,1],
// [3,1,2],
// [3,2,1]
// ]


// https://leetcode.com/problems/permutations

// solution1: dfs + backtracking + set(need to convert set to array to iterate)
// solution2: dp using insertion at different positions
// - 1
// - 1,2 | 2,1
// - 1,2,3 | 1,3,2 | 3,1,2 | 2,1,3 | 2,3,1 | 3,2,1
