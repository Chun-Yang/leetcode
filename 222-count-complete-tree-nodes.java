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
  public int countNodes(TreeNode root) {
    int h = height(root);
    if (h == 0) return 0;
    int rightH = height(root.right);
    if (h == rightH + 1) return (1 << (h-1)) + countNodes(root.right);
    else return (1 << (h-2)) + countNodes(root.left);
  }

  private int height(TreeNode node) {
    int h = 0;
    while (node != null) {
      node = node.left;
      h++;
    }
    return h;
  }
}
