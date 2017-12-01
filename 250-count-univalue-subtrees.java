// Given a binary tree, write a program to count the number of Single Valued Subtrees.
// A Single Valued Subtree is one in which all the nodes have same value.
// Expected time complexity is O(n).

// Example:

// Input: root of below tree
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
// Output: 4
// There are 4 subtrees with single values.


// Input: root of below tree
//               5
//              / \
//             4   5
//            / \   \
//           4   4   5
// Output: 5
// There are five subtrees with single values.

// solution1: post order
// use a gloabl counter to count
// return Integer, null -> not a univalue subtree, number -> is univalue
// check if is leaf node
