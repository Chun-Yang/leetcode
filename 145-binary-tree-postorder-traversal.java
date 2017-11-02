// Given a binary tree, return the postorder traversal of its nodes' values.
//
//
// For example:
// Given binary tree {1,#,2,3},
//
// 1
// \
// 2
// /
// 3
//
//
//
// return [3,2,1].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


// https://leetcode.com/problems/binary-tree-postorder-traversal

// solution1: stack
import java.util.*;
class Solution {
  // right children in stack
  public List<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> values = new ArrayList<>();

    if (root == null) {
      return values;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode current = stack.pop();
      values.add(current.val);
      if (current.left != null) stack.push(current.left);
      if (current.right != null) stack.push(current.right);
    }

    Collections.reverse(values);
    return values;
  }
}
