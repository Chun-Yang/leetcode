// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
// (the number zero), return the maximum enemies you can kill using one bomb.

// The bomb kills all the enemies in the same row and column from the planted
// point until it hits the wall since the wall is too strong to be destroyed.

// Note that you can only put the bomb at an empty cell.

// Example:
// For the given grid

// 0 E 0 0
// E 0 W E
// 0 E 0 0

// return 3. (Placing a bomb at (1,1) kills 3 enemies)

// Solution1: for each empty point, we go left, right, up and down untill wall
// or edge, and count the enemies
// m: rows
// n: columns
// O(m * n * (m + n))

// Solution2: we create a map of numbers of enemies that we can kill at that spot
// and add the two maps get the max
// O(m * n)

// Solution3: https://discuss.leetcode.com/topic/48565/short-o-mn-time-o-n-space-solution/43
// space O(n)

class Solution {
  public int maxKilledEnemies(char[][] grid) {
  }
}
