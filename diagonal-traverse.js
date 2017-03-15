/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDiagonalOrder = function(matrix) {
  const n = matrix.length
  if (n === 0) {
    return []
  }
  const m = matrix[0].length
  if (m === 0) {
    return []
  }

  const nums = []
  let i = 0
  let j = 0
  let asc = true
  for (let k=0; k < m * n; k++) {
    nums.push(matrix[i][j])
    if (asc) {
      if (j === m - 1) {
        i++
        asc = false
      } else if (i === 0) {
        j++
        asc = false
      } else {
        i--
        j++
      }
    } else {
      if (i === n - 1) {
        j++
        asc = true
      } else if (j === 0) {
        i++
        asc = true
      } else {
        i++
        j--
      }
    }
  }
  return nums
};

// findDiagonalOrder([[1,2],[3,4]])
