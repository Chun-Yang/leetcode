/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  const m = obstacleGrid.length
  const n = obstacleGrid[0].length

  // initialize paths
  const paths = new Array(m)
  for (let i=0; i<m; i++) {
    paths[i] = new Array(n).fill(0)
  }
  paths[0][0] = 1 - obstacleGrid[0][0]
  for (let i=1; i<m; i++) {
    paths[i][0] = paths[i-1][0] * (1 - obstacleGrid[i][0])
  }
  for (let j=1; j<n; j++) {
    paths[0][j] = paths[0][j-1] * (1 - obstacleGrid[0][j])
  }

  // dynamic programming
  for (let i=1; i<m; i++) {
    for (let j=1; j<n; j++) {
      if (obstacleGrid[i][j] === 0) {
        paths[i][j] = paths[i-1][j] + paths[i][j-1]
      }
    }
  }

  return paths[m-1][n-1]
};
