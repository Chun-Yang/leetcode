// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
//
//
// Note:
// A solution using O(n) space is pretty straight forward.
// Could you devise a constant space solution?


// https://leetcode.com/problems/recover-binary-search-tree

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
  TreeNode first;
  TreeNode second;
  TreeNode pre;
  public void recoverTree(TreeNode root) {
    first = null;
    second = null;
    pre = new TreeNode(Integer.MIN_VALUE);
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }
  private void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    // anomally
    if (pre.val > root.val) {
      if (first == null) {
        first = pre;
        second = root;
      } else {
        second = root;
        return;
      }
    }
    pre = root;
    inorder(root.right);
  }
}
