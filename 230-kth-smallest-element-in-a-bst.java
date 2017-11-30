// Given a binary search tree,
// write a function kthSmallest to find the kth smallest element in it.
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to
// find the kth smallest frequently? How would you optimize the kthSmallest
// routine?
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


// https://leetcode.com/problems/kth-smallest-element-in-a-bst

// solution1:
// - inorder traversal and keep a counter
// time O(n) space O(height)
// - cache on the tree nodes (follow up)
// time O(height) for update
// time O(height) for getting the kth
// time O(n) for the initial run
