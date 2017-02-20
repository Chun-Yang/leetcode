# 1. binary search * 2
# class Solution(object):
#     def searchRange(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         def search(t):
#             lo, hi = 0, len(nums)
#             while lo < hi:
#                 mid = (lo + hi) // 2
#                 if nums[mid] < t:
#                     lo = mid + 1
#                 else:
#                     hi = mid
#             return lo

#         left = search(target)
#         if left < len(nums) and nums[left] == target:
#             return [left, search(target + 1) - 1]
#         else:
#             return [-1, -1]

# 2. use lib
from bisect import bisect_left, bisect_right
class Solution(object):
    def searchRange(self, nums, target):
        left = bisect_left(nums, target)
        if left < len(nums) and nums[left] == target:
            return [left, bisect_right(nums, target) - 1]
        else:
            return [-1, -1]

# assert Solution().searchRange([1,2,4,5,5], 3) == [-1, -1]
# assert Solution().searchRange([1,2,3,3,5], 3) == [2, 3]
# assert Solution().searchRange([1,2,3,4,5], 3) == [2, 2]
