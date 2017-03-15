const { TreeNode, numsToBst, serializeBinaryTree } = require('./helpers')

function successor (bst, num) {
  if (!bst) {
    return null
  }
  if (bst.val > num) {
    const betterValue = successor(bst.left, num)
    return betterValue === null ? bst.val : betterValue
  } else {
    return successor(bst.right, num)
  }
}

// const assert = require('assert')
// assert.strictEqual(successor(numsToBst([3,2,1]), 2), 3)
// assert.strictEqual(successor(numsToBst([]), 2), null)
// assert.strictEqual(successor(numsToBst([9,2,1,4]), 2), 4)
