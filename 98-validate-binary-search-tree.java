public class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  private boolean isValid(TreeNode cur, long min, long max) {
    if (cur == null) return true;
    if (cur.val <= min || cur.val >= max) return false;
    return isValid(cur.left, min, Math.min(cur.val, max)) &&
      isValid(cur.right, Math.max(cur.val, min), max);
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
