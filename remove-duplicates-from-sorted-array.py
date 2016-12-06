class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l == 0:
            return 0

        lo, hi = 1, 1
        while hi < l:
            if nums[hi] != nums[hi - 1]:
                nums[lo] = nums[hi]
                lo += 1
            hi += 1

        return lo
