class Solution(object):
    def canIWin(self, maxChoosableInteger, desiredTotal):
        """
        :type maxChoosableInteger: int
        :type desiredTotal: int
        :rtype: bool
        """
        if desiredTotal <= 0:
            return True

        maxTotal = (1 + maxChoosableInteger) * maxChoosableInteger // 2
        if maxTotal < desiredTotal:
            return False

        cache = {}

        def dfs(integers, d):
            # print("integers, d", integers, d)
            if (integers, d) in cache:
                return cache[(integers, d)]

            if (integers >> (d - 1)) > 0:
                return True

            i, temp = 1, integers
            while temp:
                if (temp & 1) and not dfs(integers & (~(1 << (i - 1))), d - i):
                    cache[(integers, d)] = True
                    return True
                temp >>= 1
                i += 1

            cache[(integers, d)] = False
            return False

        return dfs((1 << maxChoosableInteger) - 1, desiredTotal)

# assert Solution().canIWin(5, 50) == False
