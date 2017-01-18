class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        size, candidates = len(candidates), sorted(candidates, reverse=True)
        combination, ans = [], []

        def dfs(startIndex, target):
            for i in range(startIndex, size):
                value = candidates[i]
                if target > value:
                    combination.append(value)
                    dfs(i, target - value)
                    combination.pop()
                elif target == value:
                    ans.append(combination + [value])

        dfs(0, target)
        # print("ans", ans)
        return ans

# Solution().combinationSum([2,3,6,7], 7)
