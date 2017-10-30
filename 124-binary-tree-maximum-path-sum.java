// Given a binary tree, find the maximum path sum.
//
//
// For this problem, a path is defined as any sequence of nodes from some
// starting node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the
// root.
//
//
// For example:
// Given the below binary tree,
//
// 1
// / \
// 2   3
//
//
//
// Return 6.


// https://leetcode.com/problems/binary-tree-maximum-path-sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  int max;
  public int maxPathSum(TreeNode root) {
    int max = 0;
    maxSinglePathSum(root);
    return max;
  }
  private int maxSinglePathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxLeft = maxSinglePathSum(root.left);
    int maxRight = maxSinglePathSum(root.right);
    max = Math.max(
        root.val + Math.max(0, maxLeft) + Math.max(0, maxRight),
        max
        );
    return root.val + Math.max(0, Math.max(maxLeft, maxRight));
  }
}
