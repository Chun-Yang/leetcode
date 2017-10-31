// There are N children standing in a line. Each child is assigned a rating value.
//
//
// You are giving candies to these children subjected to the following requirements:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// What is the minimum candies you must give?


// https://leetcode.com/problems/candy

// two pass, left -> right, right -> left

import java.util.*;

class Solution {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    for (int i=1; i<n; i++) {
      if (ratings[i] > ratings[i-1]) {
        candies[i] = candies[i-1] + 1;
      }
    }
    for (int i=n-2; i>=0; i--) {
      if (ratings[i] > ratings[i+1]) {
        candies[i] = Math.max(candies[i], candies[i+1] + 1);
      }
    }
    int total = 0;
    for (int i=0; i<n; i++) {
      total += candies[i];
    }
    return total;
  }
}
