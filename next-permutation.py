class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        size = len(nums)

        # find left
        left = -1
        for i in reversed(range(size - 1)):
            if nums[i] < nums[i + 1]:
                left = i
                break

        if left == -1:
            nums.reverse()
            return

        # find right
        right = -1
        for i in reversed(range(size)):
            if nums[i] > nums[left]:
                right = i
                break

        # swap
        nums[left], nums[right] = nums[right], nums[left]
        nums[left + 1:] = reversed(nums[left + 1:])


# x = [1,2,3]
# Solution().nextPermutation(x)
# print("x", x)
