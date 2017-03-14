function findMax (root) {
  return root.right ? findMax(root.right) : root.val
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
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function(root, key) {
  if (!root) {
    return root
  } else if (key > root.val) {
    root.right = deleteNode(root.right, key)
    return root
  } else if (key < root.val) {
    root.left = deleteNode(root.left, key)
    return root
  } else {
    // delete node
    if (root.left && root.right) {
      root.val = findMax(root.left)
      root.left = deleteNode(root.left, root.val)
      return root
    } else {
      return root.left || root.right
    }
  }
};
