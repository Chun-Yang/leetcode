/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Solution {
//   public List<Integer> preorderTraversal(TreeNode root) {
//     Stack<TreeNode> stack = new Stack<>();
//     TreeNode node = root;
//     ArrayList<Integer> values = new ArrayList<>();
//     while (true) {
//       if (node == null) {
//         if (stack.isEmpty()) break;
//         node = stack.pop().right;
//       } else {
//         values.add(node.val);
//         if (node.left != null) {
//           stack.push(node);
//           node = node.left;
//         } else if (node.right != null) {
//           node = node.right;
//         } else {
//           node = null;
//         }
//       }
//     }
//     return values;
//   }
// }

public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    ArrayList<Integer> values = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      values.add(node.val);
      if (node.right != null) stack.push(node.right);
      if (node.left != null) stack.push(node.left);
    }
    return values;
  }
}
