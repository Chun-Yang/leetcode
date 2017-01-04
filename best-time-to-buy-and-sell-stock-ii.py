class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # max profit for any sequence that ends with buy or buy and hold
        buy = - float('inf')
        # max profit for any sequence that ends with sell or sell and hold
        sell = 0
        for price in prices:
            sell, buy = max(sell, buy + price), max(buy, sell - price)

        return sell
