class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]

        pos, neg, maxProduct = 0, 0, - float('inf')

        for num in nums:
            if num > 0:
                pos, neg = max(num, pos * num), neg * num
            elif num < 0:
                pos, neg = neg * num, min(num, pos * num)
            else:
                pos, neg = 0, 0
            maxProduct = max(maxProduct, pos)

        return maxProduct

# assert Solution().maxProduct([-4, -3]) == 12
# assert Solution().maxProduct([2,-5,-2,-4,3]) == 24
