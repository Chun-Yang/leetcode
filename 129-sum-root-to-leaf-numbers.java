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
  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    return preorder(root, 0);
  }
  private int preorder(TreeNode root, int preVal) {
    if (root.left == null && root.right == null) {
      return preVal * 10 + root.val;
    }
    return (root.left == null ? 0 : preorder(root.left, preVal * 10 + root.val)) +
      (root.right == null ? 0 : preorder(root.right, preVal * 10 + root.val));
  }
}
