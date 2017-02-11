def coinChange(coins, amount):
    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """
    minAmounts = [-1] * (amount + 1)
    minAmounts[0] = 0

    for i in range(1, amount + 1):
        for coin in coins:
            if i >= coin and minAmounts[i - coin] >= 0:
                if minAmounts[i] == -1:
                    minAmounts[i] = minAmounts[i - coin] + 1
                else:
                    minAmounts[i] = min(minAmounts[i], minAmounts[i - coin] + 1)

    return minAmounts[amount]

# assert coinChange([], 100) == -1
# assert coinChange([], 0) == 0
# assert coinChange([2, 3], 5) == 2
# assert coinChange([2, 3], 7) == 3
# assert coinChange([2, 3, 6], 7) == 3
# assert coinChange([2, 3, 7], 7) == 1
# assert coinChange([2, 4, 6], 7) == -1
