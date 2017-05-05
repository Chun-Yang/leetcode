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
  public void flatten(TreeNode root) {
    if (root != null) {
      flattenRec(root);
    }
  }
  private TreeNode flattenRec(TreeNode root) {
    if (root.left == null && root.right == null) return root;
    else if (root.left == null) {
      return flattenRec(root.right);
    }
    else if (root.right == null) {
      root.right = root.left;
      root.left = null;
      return flattenRec(root.right);
    } else {
      TreeNode leftTail = flattenRec(root.left);
      TreeNode rightTail = flattenRec(root.right);
      leftTail.right = root.right;
      root.right = root.left;
      root.left = null;
      return rightTail;
    }
  }
}
