/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  const f = [1]
  m = m - 1
  n = n - 1

  for (let i = 1; i <= m + n; i++) {
    f[i] = f[i-1] * i
  }

  return f[m + n] / (f[m] * f[n])
};
