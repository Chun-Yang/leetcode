// Given a binary tree, return the preorder traversal of its nodes' values.
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
// return [1,2,3].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


// https://leetcode.com/problems/binary-tree-preorder-traversal


// solution1: stack
import java.util.*;
class Solution {
  // right children in stack
  public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> values = new ArrayList<>();

    if (root == null) {
      return values;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode current = stack.pop();
      values.add(current.val);
      if (current.right != null) stack.push(current.right);
      if (current.left != null) stack.push(current.left);
    }

    return values;
  }
}
