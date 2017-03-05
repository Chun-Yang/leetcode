class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curSum, maxSum = nums[0], nums[0]
        for end, num in enumerate(nums[1:]):
            curSum = num if curSum < 0 else curSum + num
            maxSum = max(maxSum, curSum)
        return maxSum

# assert Solution().maxSubArray([1]) == 1
# assert Solution().maxSubArray([-1]) == -1
# assert Solution().maxSubArray([0]) == 0
# assert Solution().maxSubArray([-1, -2, -3]) == -1
# assert Solution().maxSubArray([1, 2, 3]) == 6
# assert Solution().maxSubArray([-1, 2, -5]) == 2
# assert Solution().maxSubArray([-1, 2, 3, -5]) == 5
# assert Solution().maxSubArray([-1, 2, -1, 3, -5]) == 4
# assert Solution().maxSubArray([-1, 2, -1, -4, 3, -5]) == 3
