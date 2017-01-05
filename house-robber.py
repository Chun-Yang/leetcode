class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        odd, even = 0, 0
        for i, num in enumerate(nums):
            if i % 2 == 0:
                even = max(even + num, odd)
            else:
                odd = max(odd + num, even)
        return max(odd, even)
