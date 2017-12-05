// Given a non-negative integer num,
// repeatedly add all its digits until the result has only one digit.
//
//
//
// For example:
//
//
// Given num = 38,
// the process is like: 3 + 8 = 11, 1 + 1 = 2.
// Since 2 has only one digit, return it.
//
//
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?


// https://leetcode.com/problems/add-digits

// solution1: to get O(1), it has to be a math solution,
// find a pattern and try to prove it
// http://www.flyingcoloursmaths.co.uk/a-neat-number-trick-digital-roots-and-modulo-9-arithmetic/
// 12,345 = (1 × 9,999 + 2 × 999 + 3 × 99 + 4 × 9) + (1 + 2 + 3 + 4 + 5).
// f(abc) = f((a * (99 + 1)) + (b * (9 + 1)) + c)
//        = f((a * (99 + 1)) % 9 + (b * (9 + 1)) % 9 + c % 9)
// apply this resursively, at the end, we will have:
// f(x) = f(a * 9 + b * 99 + c * 999 + ... + y) where y is a single digit < 10
// y can be obtained by x % 9 (when y != 9)
