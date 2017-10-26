// Given a binary tree, return the inorder traversal of its nodes' values.
//
//
// For example:
// Given binary tree [1,null,2,3],
//
// 1
// \
// 2
// /
// 3
//
//
//
// return [1,3,2].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


// https://leetcode.com/problems/binary-tree-inorder-traversal

import java.util.*;

// solution1: stack
// NOTE: in stack means all lefts already visited
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> nums = new ArrayList<>();
    Stack<TreeNode> parents = new Stack<>();
    TreeNode i = root;
    while (i != null) {
      parents.push(i);
      i = i.left;
    }

    while (!parents.isEmpty()) {
      TreeNode parent = parents.pop();
      nums.add(parent.val);
      TreeNode j = parent.right;
      while (j != null) {
        parents.push(j);
        j = j.left;
      }
    }
    return nums;
  }
}

// public List<Integer> preOrder(TreeNode root) {
//   if (root == null) return new ArrayList<>();

//   List<Integer> l = new ArrayList<>();
//   Stack<TreeNode> stack = new Stack<>();
//   stack.push(root);
//   while (!stack.isEmpty()) {
//     TreeNode cur = stack.pop();
//     l.add(cur.val);
//     if (cur.right != null) stack.push(cur.right);
//     if (cur.left != null) stack.push(cur.left);
//   }
//   return l;
// }
