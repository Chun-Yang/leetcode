# class Solution(object):
#     def jump(self, nums):
#         size = len(nums)
#         if size <= 1:
#             return 0

#         minSteps = 0
#         currentBoundary = 0
#         nextBoundary = 0

#         for i, num in enumerate(nums):
#             if i > currentBoundary:
#                 minSteps += 1
#                 currentBoundary = nextBoundary
#             nextBoundary = max(nextBoundary, i + num)
#             if nextBoundary >= size - 1:
#                 return minSteps + 1

#         return minSteps

class Solution(object):
    def jump(self, nums):
        lastIndex = len(nums) - 1
        minSteps = 0
        index = 0
        currentBoundary = 0
        nextBoundary = 0

        while currentBoundary < lastIndex:
            if index > currentBoundary:
                minSteps += 1
                currentBoundary = nextBoundary
            nextBoundary = max(nextBoundary, index + nums[index])
            index += 1

        return minSteps
