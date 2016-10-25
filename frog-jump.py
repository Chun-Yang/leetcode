class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        if stones[1] != 1:
            return False

        # (currentPos, previousStep): canCross
        memo = {}

        def canCrossAt(i, k):
            if (i, k) in memo:
                return memo[(i, k)]

            if i == len(stones) - 1:
                memo[(i, k)] = True
            else:
                memo[(i, k)] = False

                for j in range(i + 1, len(stones)):
                    diff = stones[j] - stones[i]
                    if diff > k + 1:
                        break
                    if diff >= k - 1 and canCrossAt(j, diff):
                        memo[(i, k)] = True
                        break

            return memo[(i, k)]

        res = canCrossAt(1, 1)
        return res



# assert Solution().canCross([0,1,3,5,6,8,12,17]) == True
# assert Solution().canCross([0,1,2,3,4,8,9,11]) == False
