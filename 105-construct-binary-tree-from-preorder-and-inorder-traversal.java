import java.util.*;

public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
  }
  private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart == preEnd) return null;

    int val = preorder[preStart];
    TreeNode root = new TreeNode(val);

    int leftLen = 0;
    while (inorder[inStart + leftLen] != val) leftLen++;
    TreeNode left = build(
        preorder,
        inorder,
        preStart + 1,
        preStart + 1 + leftLen,
        inStart,
        inStart + leftLen);
    TreeNode right = build(
        preorder,
        inorder,
        preStart + 1 + leftLen,
        preEnd,
        inStart + 1 + leftLen,
        inEnd);

    root.left = left;
    root.right = right;
    return root;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
