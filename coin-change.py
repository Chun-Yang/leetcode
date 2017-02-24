class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        counts = [0] + [float('inf')] * amount

        for a in range(1, amount + 1):
            for coin in coins:
                if a >= coin:
                    counts[a] = min(1 + counts[a-coin], counts[a])

        if counts[amount] == float('inf'):
            return -1
        else:
            return counts[amount]

# assert Solution().coinChange([1], 1) == 1
