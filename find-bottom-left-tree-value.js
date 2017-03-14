function postOrder (node, deepth) {
  if (!node.left && !node.right) {
    return { value: node.val, deepth: deepth }
  }
  if (!node.left) {
    return postOrder(node.right, deepth + 1)
  }
  if (!node.right) {
    return postOrder(node.left, deepth + 1)
  }
  const l = postOrder(node.left, deepth + 1)
  const r = postOrder(node.right, deepth + 1)
  if (l.deepth >= r.deepth) {
    return l
  } else {
    return r
  }

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
var findBottomLeftValue = function(root) {
  const valueAndDeepth = postOrder(root, 0)
  return valueAndDeepth.value
};
