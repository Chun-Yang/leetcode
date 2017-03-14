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
var findFrequentTreeSum = function(root) {
  if (!root) {
    return []
  }

  const frequencies = {}

  function inOrder (node) {
    if (!node) {
      return 0
    }
    const sum = inOrder(node.left) + node.val + inOrder(node.right)
    frequencies[sum] = sum in frequencies ? frequencies[sum] + 1 : 1
    return sum
  }

  inOrder(root)

  const maxFrequency = Math.max.apply(null, Object.values(frequencies))

  const sums = []
  for (let key in frequencies) {
    if (frequencies[key] === maxFrequency) {
      sums.push(parseInt(key))
    }
  }
  return sums
};
