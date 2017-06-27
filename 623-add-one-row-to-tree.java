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
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    return dfs(root, v, d, true);
  }
  private TreeNode dfs(TreeNode node, int v, int d, boolean isLeft) {
    if (d == 1) {
      TreeNode newNode = new TreeNode(v);
      if (isLeft) newNode.left = node;
      else newNode.right = node;
      return newNode;
    }
    if (node == null) return null;

    node.left = dfs(node.left, v, d-1, true);
    node.right = dfs(node.right, v, d-1, false);

    return node;
  }
}
