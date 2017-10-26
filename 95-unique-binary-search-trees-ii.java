// Given an integer n,
// generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//
// 1         3     3      2      1
// \       /     /      / \      \
// 3     2     1      1   3      2
// /     /       \                 \
// 2     1         2                 3


// https://leetcode.com/problems/unique-binary-search-trees-ii

// solution1: dfs
import java.util.*;
class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<TreeNode>();
    return dfs(1, n);
  }
  private List<TreeNode> dfs(int start, int end) {
    ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    if (start > end) {
      trees.add(null);
    } else {
      for (int i=start; i<=end; i++) {
        List<TreeNode> lefts = dfs(start, i-1);
        List<TreeNode> rights = dfs(i+1, end);
        for (TreeNode left : lefts) {
          for (TreeNode right : rights) {
            TreeNode parent = new TreeNode(i);
            parent.left = left;
            parent.right = right;
            trees.add(parent);
          }
        }
      }
    }
    return trees;
  }
}
