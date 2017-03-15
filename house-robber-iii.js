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
var rob = function(root) {
  /**
   * @return [maxInclude, maxExclude]
   */
  function dfs (node) {
    if (!node) {
      return [0, 0]
    }
    const [leftInclude, leftExclude] = dfs(node.left)
    const [rightInclude, rightExclude] = dfs(node.right)
    return [
      leftExclude + rightExclude + node.val,
      Math.max(leftInclude, leftExclude) + Math.max(rightInclude, rightExclude)
    ]
  }

  return Math.max.apply(Math, dfs(root))
};
