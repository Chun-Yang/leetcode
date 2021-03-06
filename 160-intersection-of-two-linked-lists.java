// Write a program to find the node at which the intersection of two singly linked lists begins.
//
// For example, the following two linked lists:
//
// A:          a1 → a2
//                     ↘
//                     c1 → c2 → c3
//                     ↗
// B:     b1 → b2 → b3
//
// begin to intersect at node c1.
//
// Notes:
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.


// https://leetcode.com/problems/intersection-of-two-linked-lists

// solution1: get length of A and length of B, move the longer one first
// then move them at the same time to check if they meet

// solution2: connect end with another headB and find if there is a loop
// in headA, find the entry pointer of the loop
