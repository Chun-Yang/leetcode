// Given a string s1, we may represent it as a binary tree by partitioning it
// to two non-empty substrings recursively.
//
//
// Below is one possible representation of s1 = "great":
//
//
// great
// /    \
// gr    eat
// / \    /  \
// g   r  e   at
// / \
// a   t
//
//
// To scramble the string, we may choose any non-leaf node and swap its two children.
//
//
// For example, if we choose the node "gr" and swap its two children,
// it produces a scrambled string "rgeat".
//
//
// rgeat
// /    \
// rg    eat
// / \    /  \
// r   g  e   at
// / \
// a   t
//
//
// We say that "rgeat" is a scrambled string of "great".
//
//
// Similarly, if we continue to swap the children of nodes "eat" and "at", it
// produces a scrambled string "rgtae".
//
//
// rgtae
// /    \
// rg    tae
// / \    /  \
// r   g  ta  e
// / \
// t   a
//
//
// We say that "rgtae" is a scrambled string of "great".
//
//
// Given two strings s1 and s2 of the same length, determine if s2 is a
// scrambled string of s1.


// https://leetcode.com/problems/scramble-string

// solution1: dfs
// try all sorts of scramble to see if we get a match
class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1.length() != s1.length()) return false;

    int length = s1.length();
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();

    return dfs(
        chars1, 0, length - 1,
        chars2, 0, length - 1
        );
  }
  // cache start1, end1, start2, end2
  private boolean dfs(
        char[] chars1, int start1, int end1,
        char[] chars2, int start2, int end2
      )
  {
    if (start1 == end1) return chars1[start1] == chars2[start2];
    // check if counter match (pruning)
    int[] counter = new int[26];
    for (int i1=start1; i1<=end1; i1++) counter[chars1[i1]-'a']++;
    for (int i2=start2; i2<=end2; i2++) counter[chars2[i2]-'a']--;
    for (int i=0; i<26; i++) {
      if (counter[i] != 0) return false;
    }

    // check all dividers
    for (int l = 1; l <= end1 - start1; l++) {
      if (
          (
           dfs(chars1, start1, start1 + l - 1, chars2, start2, start2 + l - 1) &&
           dfs(chars1, start1 + l, end1, chars2,  start2 + l, end2)
          ) ||
          (
           dfs(chars1, start1, start1 + l - 1, chars2,  end2 - l + 1, end2) &&
           dfs(chars1, start1 + l, end1, chars2,  start2, end2 - l)
           )
         ) return true;
    }
    return false;
  }
}

// solution2: dp
// dimension1: length
// dimension2: start index1
// dimension3: start index2
// https://discuss.leetcode.com/topic/36715/simple-iterative-dp-java-solution-with-explanation
