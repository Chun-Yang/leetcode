function dfs (node, left, right) {
  if (!node) {
    return Infinity
  }
  return Math.min(
    dfs(node.left, left, node.val),
    dfs(node.right, node.val, right),
    Math.min(node.val - left, right - node.val)
  )
}
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
var getMinimumDifference = function(root) {
  return dfs(root, - Infinity, Infinity)
};
