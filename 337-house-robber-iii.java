// The thief has found himself a new place for his thievery again. There is only
// one entrance to this area, called the "root." Besides the root, each house has
// one and only one parent house. After a tour, the smart thief realized that "all
// houses in this place forms a binary tree". It will automatically contact the
// police if two directly-linked houses were broken into on the same night.

// Determine the maximum amount of money the thief can rob tonight without
// alerting the police.

// Example 1:
//      3
//     / \
//    2   3
//     \   \
//      3   1
// Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// Example 2:
//      3
//     / \
//    4   5
//   / \   \
//  1   3   1
// Maximum amount of money the thief can rob = 4 + 5 = 9.

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
  class NodeValues {
    int includesOwn;
    int notIncludesOwn;
    public NodeValues(int includesOwn, int notIncludesOwn) {
      this.includesOwn = includesOwn;
      this.notIncludesOwn = notIncludesOwn;
    }
  }
  public int rob(TreeNode root) {
    NodeValues v = inOrder(root);
    return Math.max(v.includesOwn, v.notIncludesOwn);
  }
  NodeValues inOrder (TreeNode root) {
    if (root == null) return new NodeValues(0, 0);
    NodeValues left = inOrder(root.left);
    NodeValues right = inOrder(root.right);
    return new NodeValues(
        root.val + left.notIncludesOwn + right.notIncludesOwn,
        Math.max(left.includesOwn, left.notIncludesOwn) + Math.max(right.includesOwn, right.notIncludesOwn)
        );
  }
}
