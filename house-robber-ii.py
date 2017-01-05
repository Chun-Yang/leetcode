class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        if len(nums) < 3:
            return max(nums)

        def robLinear(nums):
            odd, even = 0, 0
            for i, num in enumerate(nums):
                if i % 2 == 0:
                    even = max(even + num, odd)
                else:
                    odd = max(odd + num, even)
            return max(odd, even)

        return max(nums[0] + robLinear(nums[2:-1]), robLinear(nums[1:]))
