class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        half, residue = divmod(sum(nums), 2)
        if residue:
            return False

        nums = sorted(nums, reverse=True)
        if nums[0] > half:
            return False
        if nums[0] == half:
            return True

        def dfs(nums, target):
            for i, num in enumerate(nums):
                if num == target or (num < target and dfs(nums[:i]+nums[i+1:], target - num)):
                    return True
            return False

        return dfs(nums[1:], half - nums[0])

# assert Solution().canPartition([1, 1])
