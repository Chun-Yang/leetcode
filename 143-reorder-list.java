// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//
// You must do this in-place without altering the nodes' values.
//
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.


// https://leetcode.com/problems/reorder-list

// 1. can we do it one at a time from start to finish?
// not easily
// 2. split(slow,fast) + reverse the second one + merge
