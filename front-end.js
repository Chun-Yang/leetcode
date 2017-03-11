const assert = require('assert')

function isMatrixSquare(matrix) {
  const n = matrix.length
  for (let i = 0; i < n - 1; i++) {
    for (let j = i; j < n; j++) {
      if (matrix[i][j] !== matrix[j][i]) {
        return false
      }
    }
  }

  return true
}

assert(isMatrixSquare([]))
assert(isMatrixSquare([[1]]))
assert(isMatrixSquare([[1, 2], [2, 3]]))
assert(!isMatrixSquare([[1, 3], [2, 1]]))
