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
  public int maxPathSum(TreeNode root) {
    int[] sums = maxPathSums(root);
    return sums[1];
  }
  private int[] maxPathSums(TreeNode node) {
    if (node == null) return new int[]{ Integer.MIN_VALUE, Integer.MIN_VALUE };

    int[] leftSums = maxPathSums(node.left);
    int[] rightSums = maxPathSums(node.right);
    // [can, cannot]
    // can: must include current
    // - current + max(leftcan, rightcan, 0)
    // all:
    // - current + max(leftcan, 0) + max(rightcan, 0)
    // - leftAll
    // - rightAll
    int can = node.val + Math.max(Math.max(leftSums[0], rightSums[0]), 0);
    int all = Math.max(
        node.val + Math.max(leftSums[0], 0) + Math.max(rightSums[0], 0),
        Math.max(leftSums[1], rightSums[1])
        );
    return new int[]{ can, all };
  }
}
// [1,-2,-3,1,3,-2,null,-1]
//        1
//    -2     -3
//   1  3  -2
//  -1
