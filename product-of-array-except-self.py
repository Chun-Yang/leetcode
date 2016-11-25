class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        res = [1] * len(nums)
        right = 1

        for i in range(1, len(nums)):
            res[i] = res[i-1] * nums[i-1]

        for i in reversed(range(len(nums))):
            res[i] = res[i] * right
            right = right * nums[i]

        return res
