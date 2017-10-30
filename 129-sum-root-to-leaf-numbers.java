// Given a binary tree containing digits from 0-9 only,
// each root-to-leaf path could represent a number.
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
// Find the total sum of all root-to-leaf numbers.
//
// For example,
//
// 1
// / \
// 2   3
//
//
//
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
//
//
// Return the sum = 12 + 13 = 25.


// https://leetcode.com/problems/sum-root-to-leaf-numbers

// solution1: dfs to find the depth of the tree
// another dfs to calculate the sum

// solution2: dfs value = parentValue * 10 + value,
// use a global counter to count this
