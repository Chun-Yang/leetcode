// A linked list is given such that each node contains an additional random
// pointer which could point to any node in the list or null.
//
//
//
// Return a deep copy of the list.


// https://leetcode.com/problems/copy-list-with-random-pointer

// solution1: create a hash,
// the key is the original node and the value is the copy
// time O(n) space O(n)

// solution2: a->a'->b->b'
