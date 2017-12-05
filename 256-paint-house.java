// There are a row of n houses, each house can be painted with one of the three colors:
// red, blue or green.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
// For example,
// costs[0][0] is the cost of painting house 0 with color red;
// costs[1][2] is the cost of painting house 1 with color green,
// and so on... Find the minimum cost to paint all houses.

// solution1: dp
// keep track of min costs that ends with a specifc color
// minCosts = new int[]{ costs[0][0], costs[0][1], costs[0][2] }
// for cost index i: minCosts[j] = Math.min(
// minCosts[(j+1) % 3] + costs[i][(j+1) % 3],
// minCosts[(j+2) % 3] + costs[i][(j+2) % 3],
// )
