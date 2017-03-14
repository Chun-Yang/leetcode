function countPairs (node, num) {
  if (!node) {
    return 0
  }
  if (node.val > 2 * num) {
    return 1 + node.largerCount + countPairs(node.left, num)
  } else {
    return countPairs(node.right, num)
  }
}

function insertNumber (node, num) {
  let direction
  if (num < node.val) {
    direction = 'left'
  } else {
    node.largerCount += 1
    direction = 'right'
  }

  if (!node[direction]) {
    node[direction] = { val: num, largerCount: 0 }
  } else {
    insertNumber(node[direction], num)
  }
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
  if (nums.length <= 1) {
    return 0
  }

  const root = { val: nums[0], largerCount: 0 }
  let count = 0
  for (let i=1; i<nums.length; i++) {
    count += countPairs(root, nums[i])
    insertNumber(root, nums[i])
  }

  return count
};

// const assert = require('assert')
// assert.deepEqual(reversePairs([2,4,3,5,1]), 3)
