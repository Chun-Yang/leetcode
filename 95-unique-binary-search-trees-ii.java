public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<>();
    return generateTrees(1, n);
  }
  private List<TreeNode> generateTrees(int start, int end) {
    ArrayList<TreeNode> trees = new ArrayList<>();

    if (start > end) {
      trees.add(null);
      return trees;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> lefts = generateTrees(start, i - 1);
      List<TreeNode> rights = generateTrees(i + 1, end);
      for (TreeNode left: lefts) {
        for (TreeNode right: rights) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          trees.add(root);
        }
      }
    }

    return trees;
  }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
