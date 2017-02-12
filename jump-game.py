# class Solution(object):
#     def canJump(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: bool
#         """
#         l = len(nums)
#         dp = [False] * l
#         dp[-1] = True
#         for i in reversed(range(l - 1)):
#             j = i + 1
#             while j < min(i + nums[i] + 1, l):
#                 if dp[j]:
#                     dp[i] = True
#                     break
#                 j += nums[j] + 1

#         return dp[0]

# class Solution(object):
#     def canJump(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: bool
#         """
#         size = len(nums)
#         if size <= 1:
#             return True

#         failed = [False] * size
#         stack = [[0, nums[0]]]
#         while True:
#             index, offset = stack[-1]
#             if index + offset >= size - 1:
#                 return True
#             while offset == 0 or failed[index]:
#                 if offset == 0:
#                     failed[index] = True
#                 stack.pop()
#                 if not stack:
#                     return False
#                 stack[-1][1] -= 1
#                 index, offset = stack[-1]
#             stack.append([index + offset, nums[index + offset]])

#         return False

# class Solution(object):
#     def canJump(self, nums):
#         latest = len(nums) - 1

#         for i in reversed(range(len(nums) - 1)):
#             if i + nums[i] >= latest:
#                 latest = i

#         return latest <= 0

class Solution(object):
    def canJump(self, nums):
        maxIndex = 0
        lastIndex = len(nums) - 1
        for i, num in enumerate(nums):
            if i > maxIndex:
                return False
            maxIndex = max(maxIndex, i + num)
        return True

# assert Solution().canJump([1,2,3,4])
# assert not Solution().canJump([0,0,0,0])
# assert Solution().canJump([2, 5, 0, 0])
