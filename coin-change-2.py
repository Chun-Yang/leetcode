class Solution(object):
    # v1.0 dp
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        counts = [1] + [0] * amount
        for i, coin in enumerate(coins):
            for j in range(1, amount + 1):
                if j >= coin:
                    counts[j] += counts[j-coin]
        return counts[amount]

# assert Solution().change(100, [1,101,102,103]) == 1
# assert Solution().change(5, [1,2,5]) == 4
