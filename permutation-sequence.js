/**
 * @param {number} n
 * @param {number} k 1-based
 * @return {string}
 */
var getPermutation = function(n, k) {
  const nums = new Array(n)
  let totalCount = 1
  k = k - 1
  for (let i=1; i<=n; i++) {
    totalCount *= i
    nums[i-1] = i
  }

  const permutation = new Array(n)
  for (let i=1; i<=n; i++) {
    totalCount = totalCount / nums.length
    const index = Math.floor(k / totalCount)
    permutation[i-1] = (nums.splice(index, 1)[0])
    k = k % totalCount
  }

  return permutation.join('')
};

// const assert = require('assert')
// assert.strictEqual(getPermutation(3, 2), '132')
// assert.strictEqual(getPermutation(3, 6), '321')
// assert.strictEqual(getPermutation(4, 3), '1324')
// assert.strictEqual(getPermutation(4, 4), '1342')
