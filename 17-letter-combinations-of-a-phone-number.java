// Given a digit string, return all possible letter combinations that the number could represent.
//
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
//
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.


// https://leetcode.com/problems/letter-combinations-of-a-phone-number

// solution1: dfs backtracking
// n is the number of digits, m is the letters of each digit
// time: O(m^n) space: O(m^n) the recursion stack takes O(n)
class Solution {
  public List<String> letterCombinations(String digits) {

  }
}

// solution2: Queue (BFS)
// https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue
