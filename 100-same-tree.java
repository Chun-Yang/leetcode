public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) return q == null;
    if (q == null) return p == null;
    return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
