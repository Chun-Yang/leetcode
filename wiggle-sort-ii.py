class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        sortedNums = sorted(nums)
        size = len(nums)
        half = (size + 1) // 2
        smallHalf = sortedNums[:half][::-1]
        largeHalf = sortedNums[half:][::-1]
        # print("smallHalf", smallHalf)
        # print("largeHalf", largeHalf)
        for i in range(size):
            if i % 2 == 0:
                nums[i] = smallHalf[i // 2]
            else:
                nums[i] = largeHalf[i // 2]

# x = [4,5,5,6]
# Solution().wiggleSort(x)
# print("x", x)
