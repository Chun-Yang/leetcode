// Say you have an array for which
// the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit.
// You may complete at most k transactions.
//
// Note:
// You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

// solution: dynamic programming
// sell[k] the max value that ends this day with maximum k sells
// buy[k]  the max value that ends this day with maximum k buys
