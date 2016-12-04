class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def search(lo, hi):
            if nums[lo] == target and nums[hi] == target:
                return [lo, hi]
            elif nums[lo] <= target and nums[hi] >= target:
                mid = (lo + hi) // 2
                llo, lhi = search(lo, mid)
                rlo, rhi = search(mid + 1, hi)
                if llo == -1 or rlo == -1:
                    return max([llo, lhi], [rlo, rhi])
                else:
                    return [llo, rhi]
            else:
                return [-1, -1]

        return search(0, len(nums) - 1)

# assert Solution().searchRange([2, 3, 3, 4], 3) == [1, 2]
# assert Solution().searchRange([3, 3, 4], 3) == [0, 1]
# assert Solution().searchRange([1, 2, 3], 3) == [2, 2]
# assert Solution().searchRange([1, 2, 2], 3) == [-1, -1]
