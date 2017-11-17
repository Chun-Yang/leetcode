// Given a nested list of integers, return the sum of all integers in the list
// weighted by their depth.

// Each element is either an integer, or a list -- whose elements may also be
// integers or other lists.

// Different from the previous question where weight is increasing from root to
// leaf, now the weight is defined from bottom up. i.e., the leaf level integers
// have weight 1, and the root level integers have the largest weight.

// Example 1:
// Given the list [[1,1],2,[1,1]], return 8.
// (four 1's at depth 1, one 2 at depth 2)

// Example 2:
// Given the list [1,[4,[6]]], return 17.
// (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

// solution1: two dfs, first get depth, second get values
// solution2: bfs, get values in each level and get pop them combined the current depth
// Solution3: https://discuss.leetcode.com/topic/49041/no-depth-variable-no-multiplication

class Solution {
  public int depthSumInverse(ArrayList<NestedInteger> nestedList) {
    int weighted = 0;
    int unweighted = 0;

    while (!nestedList.isEmpty()) {
      ArrayList<NestedInteger> nextNestedList = new ArrayList<NestedInteger>();
      for (NestedInteger ni : nestedList) {
        if (ni.isInteger()) unweighted += ni.getInteger();
        else nextNestedList.addAll(ni.getList());
      }
      nestedList = nextNestedList;
      weighted += unweighted;
    }

    return weighted;
  }
}
