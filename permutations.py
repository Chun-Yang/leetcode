class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        size, ans, perm = len(nums), [], []

        def dfs(nums, size):
            if size == 0:
                ans.append(perm[:])
                return
            for i in range(size):
                perm.append(nums[i])
                dfs(nums[:i] + nums[i+1:], size - 1)
                perm.pop()

        dfs(nums, size)

        return ans

# Solution().permute([1,2,3])
