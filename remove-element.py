class Solution(object):
    def removeElement(self, nums, val):
        l = len(nums)
        i = 0
        while i < l:
            while nums[i] == val and i < l:
                l -= 1
                nums[i] = nums[l]
            i += 1
        return l


# class Solution(object):
#     def removeElement(self, nums, val):
#         """
#         :type nums: List[int]
#         :type val: int
#         :rtype: int
#         """
#         l = len(nums)
#         if l == 0:
#             return 0

#         lo, hi = 0, l - 1
#         while lo < hi:
#             while nums[hi] == val and lo < hi:
#                 hi -= 1
#             while nums[lo] != val and lo < hi:
#                 lo += 1
#             nums[lo], nums[hi] = nums[hi], nums[lo]

#         if lo == 0 and nums[0] == val:
#             return 0
#         else:
#             return lo + 1

# nums = [3,3]
# val = 3
# r = Solution().removeElement(nums, 3)
# print("nums", nums)
# print("r", r)
