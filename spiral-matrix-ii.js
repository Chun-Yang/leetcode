/**
 * @param {number} n
 * @return {number[][]}
 */
function generateMatrix (n) {
  // initialize matrix
  matrix = []
  for (let i=0; i<n; i++) {
    matrix[i] = []
  }

  // fill in matrix
  middle = Math.floor(n / 2)
  value = 1
  for (let i=0; i<middle; i++) {
    for (let j=i; j<n-i-1; j++) {
      matrix[i][j] = value
      value++
    }
    for (let j=i; j<n-i-1; j++) {
      matrix[j][n-i-1] = value
      value++
    }
    for (let j=n-i-1; j>i; j--) {
      matrix[n-i-1][j] = value
      value++
    }
    for (let j=n-i-1; j>i; j--) {
      matrix[j][i] = value
      value++
    }
  }

  // fill in the center when n is odd
  if (n % 2 === 1) {
    matrix[middle][middle] = n * n
  }

  return matrix
}

// console.log(generateMatrix(4))
