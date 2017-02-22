class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates = sorted(candidates, reverse=True)
        size = len(candidates)

        def dfs(startIndex, targetValue):
            if targetValue == 0:
                return [[]]
            if startIndex == size:
                return []

            combs = []
            startCount = 0
            startValue = candidates[startIndex]
            while targetValue >= startCount * startValue:
                for comb in dfs(startIndex + 1, targetValue - startCount * startValue):
                    combs.append(comb + [startValue] * startCount)
                startCount += 1

            return combs

        combs = dfs(0, target)
        return combs

# Solution().combinationSum([2,3,6,7], 7)
