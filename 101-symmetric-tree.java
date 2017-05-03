public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> leftStack = new Stack<TreeNode>();
    Stack<TreeNode> rightStack = new Stack<TreeNode>();
    leftStack.push(root.left);
    rightStack.push(root.right);
    while (true) {
      TreeNode left = leftStack.pop();
      TreeNode right = rightStack.pop();
      if (left == null || right == null) {
        if (left != right) return false;
      } else {
        if (left.val != right.val) return false;
        leftStack.push(left.left);
        leftStack.push(left.right);
        rightStack.push(right.right);
        rightStack.push(right.left);
      }

      if (leftStack.empty()) return true;
    }
  }
  // public boolean isSymmetric(TreeNode root) {
  //   if (root == null) return true;
  //   return compare(root.left, root.right);
  // }
  // private boolean compare(TreeNode left, TreeNode right) {
  //   if (left == null || right == null) return left == right;
  //   if (left.val != right.val) return false;
  //   return compare(left.left, right.right) && compare(left.right, right.left);
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
