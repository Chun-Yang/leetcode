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
  // pre: middle, left, right
  // -> middle, right, left
  // -> reverse
  // post: left, right, middle
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> values = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      values.add(node.val);
      if (node.left != null) stack.push(node.left);
      if (node.right != null) stack.push(node.right);
    }

    Collections.reverse(values);
    return values;
  }
}
