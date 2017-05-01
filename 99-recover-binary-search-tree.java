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
  public void recoverTree(TreeNode root) {
    // [pre, first, second]
    TreeNode[] nodes = new TreeNode[3];
    nodes[0] = new TreeNode(Integer.MIN_VALUE);

    inorder(root, nodes);

    int temp = nodes[1].val;
    nodes[1].val = nodes[2].val;
    nodes[2].val = temp;
  }

  // return the last node
  private void inorder(TreeNode node, TreeNode[] nodes) {
    if (node == null) return;

    inorder(node.left, nodes);
    if (nodes[0].val > node.val) {
      if (nodes[1] == null) {
        nodes[1] = nodes[0];
      }
      nodes[2] = node;
    }
    nodes[0] = node;
    inorder(node.right, nodes);
  }
}
