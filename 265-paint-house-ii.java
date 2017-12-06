// There are a row of n houses, each house can be painted with one of the k colors.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have
// the same color.

// The cost of painting each house with a certain color is
// represented by a n x k cost matrix.
// For example,
// costs[0][0] is the cost of painting house 0 with color 0;
// costs[1][2] is the cost of painting house 1 with color 2, and so on...
// Find the minimum cost to paint all houses.

// solution1: dp
// int[] minCosts = new int[k]
// for each house, we get the minCosts that ends with a specifc color
// time: O(n * k) space: O(k)

// solution2: dp
// time: O(n * k) space: O(1)
// insight: we do not need all values that ends with a specifc color,
// we only need min, minColor, secondToMin
// min = Math.min(min * minCostOfOtherColor, secondToMin * costOfThisColor)
// minColor = this can get using another loop, but not the minColor
// secondToMin = not this minColor
// https://discuss.leetcode.com/topic/25489/fast-dp-java-solution-runtime-o-nk-space-o-1
