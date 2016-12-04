class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = len(nums)
        lo, hi = 0, l
        while lo < hi:
            mid = lo + (hi - lo) // 2
            num = nums[mid]
            # print("lo, hi, mid", lo, hi, mid)
            if target < num:
                hi = mid
            elif target > num:
                lo = mid + 1
            else:
                return mid

        return lo

# assert Solution().searchInsert([1], 1) == 0
