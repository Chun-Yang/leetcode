// Given a binary tree where all the right nodes are either leaf nodes with a
// sibling (a left node that shares the same parent node) or empty, flip it
// upside down and turn it into a tree where the original right nodes turned
// into left leaf nodes. Return the new root.

// For example:
// Given a binary tree {1,2,3,4,5},
//     1
//    / \
//   2   3
//  / \
// 4   5
// return the root of the binary tree [4,5,2,#,#,3,1].
//    4
//   / \
//  5   2
//     / \
//    3   1


// https://leetcode.com/problems/binary-tree-upside-down

// solution1: preOrder
class Solution {
  public TreeNode flip(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode nextRoot = flip(root.left);
    root.left.left = root.right;
    root.left.right = root;
    root.left = null;
    root.right = null;
    return nextRoot;
  }
}

// solution2: iterative
// https://discuss.leetcode.com/topic/40924/java-recursive-o-logn-space-and-iterative-solutions-o-1-space-with-explanation-and-figure
// iterative is most of the time more difficute than recursive since
// you need to find a way to cache the stack, some times you only need to cache
// one thing
