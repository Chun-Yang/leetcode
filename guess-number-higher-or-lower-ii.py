# import sys
# sys.setrecursionlimit(10)

class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [ [ 0 for i in range(1 + n) ] for i in range(1 + n) ]
        for i in range(1, n + 1):
            for j in range(i, 0, -1):
                if i != j:
                    money = float('inf')
                    for k in range(j, i):
                        if k == j:
                            money = min(money, k + dp[j + 1][i])
                        elif k == i:
                            money = min(money, k + dp[j][i - 1])
                        else:
                            money = min(money, k + max(dp[j][k - 1], dp[k + 1][i]))

                    dp[j][i] = money

        return dp[1][n]

# assert Solution().getMoneyAmount(3) == 2
# assert Solution().getMoneyAmount(5) == 6
# assert Solution().getMoneyAmount(7) == 10
