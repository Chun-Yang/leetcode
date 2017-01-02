class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        minAmounts = [0] + [-1] * amount
        for i in range(1, amount + 1):
            minAmount = -1
            for c in coins:
                if c <= i:
                    preAmount = minAmounts[i - c]
                    if preAmount >= 0:
                        if minAmount > 0:
                            minAmount = min(minAmount, preAmount + 1)
                        else:
                            minAmount = preAmount + 1
            minAmounts[i] = minAmount

        return minAmounts[amount]
