/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
  if (!root) {
    return []
  }
  if (!root.left && !root.right) {
    return [root.val.toString()]
  }
  return [].concat(
    binaryTreePaths(root.left),
    binaryTreePaths(root.right)
  ).map((p) => root.val + '->' + p)
};
