class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # max profit for any sequence that ends with buy or buy and hold
        buy1 = - float('inf')
        buy2 = - float('inf')
        # max profit for any sequence that ends with sell or sell and hold
        sell1 = 0
        sell2 = 0
        for price in prices:
            sell2 = max(sell2, price + buy2)
            buy2 = max(buy2, - price + sell1)
            sell1 = max(sell1, price + buy1)
            buy1 = max(buy1, - price)

        return sell2

# assert Solution().maxProfit([1,2,3]) == 2
# assert Solution().maxProfit([1,2,3,4]) == 3
