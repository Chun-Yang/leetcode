class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # # dp
        # # max profit if buy at any day till today
        # buy = - float('inf')
        # # max profit if sell at any day till today
        # sell = 0
        # for price in prices:
        #     sell = max(sell, price + buy)
        #     buy = max(buy, -price)

        # return sell

        # two pointers
        # track the min value, the best profit if sell today is price - min
        minPrice = float('inf')
        maxProfit = 0
        for price in prices:
            maxProfit = max(maxProfit, price - minPrice)
            minPrice = min(minPrice, price)
        return maxProfit
