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
  List<String> paths;
  List<String> path;
  public List<String> binaryTreePaths(TreeNode root) {
    paths = new ArrayList<>();
    path = new LinkedList<>();
    if (root == null) return paths;
    dfs(root);
    return paths;
  }
  private void dfs(TreeNode node) {
    path.add(Integer.toString(node.val));

    if (node.left == null && node.right == null) {
      paths.add(String.join("->", path));
    } else if (node.left == null) {
      dfs(node.right);
    } else if (node.right == null) {
      dfs(node.left);
    } else {
      dfs(node.left);
      dfs(node.right);
    }

    path.remove(path.size() - 1);
  }
}
