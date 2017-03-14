/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
  if (!root) {
    return []
  }
  const leftArray = largestValues(root.left)
  const rightArray = largestValues(root.right)
  let longer, shorter
  if (leftArray.length > rightArray.length) {
    longer = leftArray
    shorter = rightArray
  } else {
    shorter = leftArray
    longer = rightArray
  }
  shorter.forEach((num, index) => {
    if (num > longer[index]) {
      longer[index] = num
    }
  })

  return [root.val].concat(longer)
};
