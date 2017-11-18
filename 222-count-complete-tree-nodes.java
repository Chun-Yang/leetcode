// Given a complete binary tree, count the number of nodes.
//
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is
// completely filled, and all nodes in the last level are as far left as
// possible. It can have between 1 and 2h nodes inclusive at the last level h.


// https://leetcode.com/problems/count-complete-tree-nodes

// solution1: count depth, use each node to determin the depth
// time: O(log(n) * log(n))


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//   public int countNodes(TreeNode root) {
//     int leftDepth = getLeftDepth(root);
//     int rightDepth = getRightDepth(root);
//     if (leftDepth == rightDepth) {
//       return (1 << leftDepth) - 1;
//     }
//     return 1 + countNodes(root.left) + countNodes(root.right);
//   }
//   private int getLeftDepth(TreeNode root) {
//     int depth = 0;
//     while (root != null) {
//       depth++;
//       root = root.left;
//     }
//     return depth;
//   }
//   private int getRightDepth(TreeNode root) {
//     int depth = 0;
//     while (root != null) {
//       depth++;
//       root = root.right;
//     }
//     return depth;
//   }
// }

// solution2: get height of left node and right node
// same:     left is full,         right may be not
// not same: left may not be full, right is
// https://discuss.leetcode.com/topic/15533/concise-java-solutions-o-log-n-2
class Solution {
  int height(TreeNode root) {
    int depth = 0;
    while (root != null) {
      root = root.left;
      depth++;
    }
    return depth;
  }
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int currentHeight = height(root);
    int rightHeight = height(root.right);
    if (currentHeight == rightHeight + 1) {
      return (1 << rightHeight) + countNodes(root.right);
    } else {
      return (1 << rightHeight) + countNodes(root.left);
    }
  }
}
