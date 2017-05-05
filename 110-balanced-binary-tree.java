/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }
  private int height(TreeNode root) {
    if (root == null) return 0;

    int left = height(root.left);
    if (left < 0) return left;

    int right = height(root.right);
    if (right < 0) return right;

    if (Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
  }
}
