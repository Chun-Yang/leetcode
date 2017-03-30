/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  if (p.val > q.val) {
    return lowestCommonAncestor(root, q, p)
  }
  if (!root) {
    return root
  }
  if (root.val < p.val) {
    return lowestCommonAncestor(root.right, p, q) || root
  }
  if (root.val > q.val) {
    return lowestCommonAncestor(root.left, p, q) || root
  }
  return root
};
