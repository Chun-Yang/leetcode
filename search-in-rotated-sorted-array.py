# # v1.0
# class Solution(object):
#     def search(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: int
#         """
#         size = len(nums)
#         lo, hi = 0, size - 1
#         while lo <= hi:
#             mid = (lo + hi) // 2
#             if nums[lo] <= nums[hi]:
#                 if target > nums[mid]:
#                     lo = mid + 1
#                 elif target < nums[mid]:
#                     hi = mid - 1
#                 else:
#                     return mid
#             else:
#                 if nums[lo] <= target < nums[mid]:
#                     hi = mid - 1
#                 elif nums[mid] < target <= nums[hi]:
#                     lo = mid + 1
#                 elif nums[mid] == target:
#                     return mid
#                 elif nums[lo] <= nums[mid]:
#                     lo = mid + 1
#                 else:
#                     hi = mid - 1
#         return -1

# assert Solution().search([3, 1], 0) == -1

# v2.0
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if target > nums[mid]:
                if nums[mid] <= nums[hi] and target > nums[hi]:
                    hi = mid - 1
                else:
                    lo = mid + 1
            elif target < nums[mid]:
                if nums[mid] >= nums[lo] and target < nums[lo]:
                    lo = mid + 1
                else:
                    hi = mid - 1
            else:
                return mid
        return -1
