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
  public int kthSmallest(TreeNode root, int k) {
    return dfs(root, k)[1];
  }
  private int[] dfs(TreeNode node, int k) {
    if (node == null) return new int[]{0, 0};

    int[] left = dfs(node.left, k);
    // found in left branch
    if (left[0] == k) return left;

    // found for current
    if (left[0] == k - 1) return new int[]{k, node.val};

    int[] right = dfs(node.right, k - left[0] - 1);
    // found for right branch
    if (right[0] == k - left[0] - 1) return new int[]{ left[0] + 1 + right[0], right[1] };

    return new int[]{left[0] + 1 + right[0], 0};
  }
}
