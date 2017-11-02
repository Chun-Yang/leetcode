// Given a linked list, determine if it has a cycle in it.
//
//
//
// Follow up:
// Can you solve it without using extra space?


// https://leetcode.com/problems/linked-list-cycle

// solution1: slow and fast pointers
// -----
//     /\_meeting point
//     \/
// a = before circle begin
// b = circle begin to meeting point
// c = meeting point to circle begin
// b + c is the circle length
// a + b + (b + c) * n = 2 * ( a + b ) where n >= 1
// (b + c) * (n - 1) + c = a
