# class Solution(object):
#     def removeDuplicates(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         size = len(nums)
#         if size <= 1:
#             return size

#         slow, fast = 1, 1

#         while True:
#             while slow < size and nums[slow] > nums[slow - 1]:
#                 slow += 1
#             fast = max(slow, fast)
#             while fast < size and nums[fast] <= nums[slow]:
#                 fast += 1
#             if fast < size:
#                 nums[slow], nums[fast] = nums[fast], nums[slow]
#             else:
#                 break

#         return slow

# class Solution(object):
#     def removeDuplicates(self, nums):
#         if not nums:
#             return 0

#         lastIndex = 0
#         for i in range(1, len(nums)):
#             if nums[lastIndex] != nums[i]:
#                 lastIndex += 1
#                 nums[lastIndex] = nums[i]

#         return lastIndex + 1

class Solution(object):
    def removeDuplicates(self, nums):
        length, left = len(nums), 0
        for right in range(1, len(nums)):
            if nums[right] > nums[left]:
                left += 1
                nums[left] = nums[right]
            else:
                length -= 1
        return length

# assert Solution().removeDuplicates([1,2,3,4,5]) == 5
# assert Solution().removeDuplicates([1,1,2,3,4,5]) == 5
# assert Solution().removeDuplicates([1,1,1,1]) == 1
# assert Solution().removeDuplicates([1,1,2,2]) == 2
