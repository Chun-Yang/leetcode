class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0

        buy = prices[0]
        sell = prices[0]
        lowest = prices[0]
        for price in prices[1:]:
            if price - lowest > sell - buy:
                buy = lowest
                sell = price
            elif price > sell:
                sell = price
            elif price < lowest:
                lowest = price


        return sell - buy
