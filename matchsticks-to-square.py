class Solution(object):
    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums = sorted(nums, reverse=True)

        size = len(nums)
        if size < 4:
            return False

        total = sum(nums)
        if total % 4 != 0:
            return False

        expected = total // 4
        sums = [0] * 4

        def dfs(i):
            if i == size:
                return all(s == expected for s in sums)

            for j in range(4):
                if sums[j] + nums[i] <= expected:
                    sums[j] += nums[i]
                    if dfs(i + 1):
                        return True
                    sums[j] -= nums[i]

            return False

        return dfs(0)

# Solution().makesquare([1,1,2,2,2])
