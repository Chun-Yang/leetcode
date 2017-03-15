/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
  const values = []
  function preOrder (node) {
    if (!node) {
      return
    }
    values.push(node.val.toString())
    preOrder(node.left)
    preOrder(node.right)
  }
  preOrder(root)
  return values.join(',')
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
  if (!data) {
    return null
  }

  function insert (node, val) {
    if (!node) {
      return new TreeNode(val)
    }
    if (val > node.val) {
      node.right = insert(node.right, val)
    } else {
      node.left = insert(node.left, val)
    }
    return node
  }
  let root = null
  data.split(',').forEach((str) => {
    root = insert(root, parseFloat(str))
  })
  return root
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
