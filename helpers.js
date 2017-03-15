function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

function numsToBst (nums) {
  function insert (node, num) {
    if (!node) {
      return new TreeNode(num)
    }
    if (num > node.val) {
      node.right = insert(node.right, num)
    } else {
      node.left = insert(node.left, num)
    }
    return node
  }
  return nums.reduce((root, num) => insert(root, num), null)
}

function serializeBinaryTree (root) {
  let nodes = [root]
  const values = []
  while (nodes.length) {
    nodes = nodes.reduce((acc, node) => {
      if (!node) {
        values.push('null')
      } else {
        values.push(node.val)
        if (node.left || node.right) {
          acc.push(node.left)
          acc.push(node.right)
        }
      }
      return acc
    }, [])
  }
  return values.join(',')
}

exports.TreeNode = TreeNode
exports.numsToBst = numsToBst
exports.serializeBinaryTree = serializeBinaryTree

// const assert = require('assert')
// assert.deepEqual(
//   serializeBinaryTree(numsToBst([3,2,1])),
//   '3,1,2'
// )
