/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
  Stack<TreeNode> ancestors = new Stack<>();

  public BSTIterator(TreeNode root) {
    while (root != null) {
      ancestors.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !ancestors.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode current = ancestors.pop();
    TreeNode right = current.right;
    while (right != null) {
      ancestors.push(right);
      right = right.left;
    }
    return current.val;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
