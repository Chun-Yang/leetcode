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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    dfs(root, list, 0);
    return list;
  }
  private void dfs(TreeNode node, List<Integer> list, int depth) {
    if (node == null) return;
    if (list.size() == depth) list.add(node.val);
    dfs(node.right, list, depth+1);
    dfs(node.left, list, depth+1);
  }
  // public List<Integer> rightSideView(TreeNode root) {
  //   if (root == null) return new ArrayList<>();

  //   List<Integer> combined = new ArrayList<>();
  //   combined.add(root.val);
  //   List<Integer> lefts = rightSideView(root.left);
  //   List<Integer> rights = rightSideView(root.right);
  //   combined.addAll(rights);
  //   if (lefts.size() > rights.size()) {
  //     combined.addAll(lefts.subList(rights.size(), lefts.size()));
  //   }
  //   return combined;
  // }
}
