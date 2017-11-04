// Design and implement a TwoSum class.
// It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// For example,

// add(1);
// add(3);
// add(5);
// find(4) -> true
// find(7) -> false


// https://leetcode.com/problems/two-sum-iii-data-structure-design

// solution1: fast find, slow add
// when we add a number,
// we calculate all the new posible numbers and save them in a set
// find O(1)
// add O(n)
// space O(n^2)

// solution2: fast add, slow find
// use a set to speed up the lookup
// find O(n)
// add O(1)
// space O(n)

// solution3: if there are a lot of duplicates, we can save counter
// we can use a single HashMap (this may be better)
// or two HashSet, one set to save singles and the other to save doubles
