// Given a string s,
// return all the palindromic permutations (without duplicates) of it.
// Return an empty list if no palindromic permutation could be form.

// For example:

// Given s = "aabb", return ["abba", "baab"].

// Given s = "abc", return [].

// solution1: dfs
// - get the count of the chars
// - case 1: no palindrome
// - case 2: odd palindrome (can be converted to even palindrome)
// - case 3: even palindrome
// - we just need to construct one side (the other side can follow)
// - dfs to loop through all chars until all chars are used
// O(n) where n is the length of s
// a                b                   c
// a   b   c        a   b   c           a   b   c
// ...
