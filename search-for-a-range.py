class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1, -1]

        lo, hi = 0, len(nums) - 1
        while lo < hi:
            mid = (lo + hi) // 2
            if nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid
        if nums[lo] != target:
            return [-1, -1]

        left = lo
        hi = len(nums) - 1
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid
        right = hi
        return [left, right]


# assert Solution().searchRange([1,2,4,5,5], 3) == [-1, -1]
# assert Solution().searchRange([1,2,3,3,5], 3) == [2, 3]
# assert Solution().searchRange([1,2,3,4,5], 3) == [2, 2]
