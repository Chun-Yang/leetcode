# class Solution(object):
#     def firstMissingPositive(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         size = len(nums)
#         for i in range(size):
#             # j is the index where we will mark the num as 0
#             j = nums[i] - 1
#             while 0 <= j < size:
#                 nums[j], j = float('inf'), nums[j] - 1
#         for i in range(size):
#             if nums[i] != float('inf'):
#                 return i + 1
#         return size + 1

class Solution(object):
    def firstMissingPositive(self, nums):
        size = len(nums)
        for i in range(size):
            j = nums[i] - 1
            while 0 <= j < size and nums[j] != j + 1:
                nums[j], j = j + 1, nums[j] - 1
        for i in range(size):
            if nums[i] != i + 1:
                return i + 1
        return size + 1

assert Solution().firstMissingPositive([0]) == 1
