/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function(root, isLeft) {
  if (!root) {
    return 0
  }
  if (!root.left && !root.right) {
    return isLeft ? root.val : 0
  }
  return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right)
};
