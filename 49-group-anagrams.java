// Given an array of strings, group anagrams together.
//
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
// [
// ["ate", "eat","tea"],
// ["nat","tan"],
// ["bat"]
// ]
//
// Note: All inputs will be in lower-case.


// https://leetcode.com/problems/group-anagrams

// solution1:
// HashMap key is the frequency array in string
// value is an ArrayList that contains strings

// solution2:
// similar to solution1, but use sorted chars as key

// Solution3:
// similar to solution1, but use multiplication of prime number as key
// https://discuss.leetcode.com/topic/45639/java-beat-100-use-prime-number
