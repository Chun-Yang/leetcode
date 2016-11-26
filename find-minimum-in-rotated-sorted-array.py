class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        lo = 0
        hi = l - 1

        if nums[hi] > nums[lo]:
            return nums[lo]

        while hi - lo > 1:
            mid = (hi + lo) // 2
            if nums[mid] > nums[lo]:
                lo = mid
            else:
                hi = mid

        return nums[hi]
