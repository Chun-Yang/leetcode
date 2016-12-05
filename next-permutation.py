class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        if l <= 1:
            return
        if nums.count(nums[0]) == l:
            return

        i = l - 2
        while i > -1 and nums[i] >= nums[i + 1]:
            i -= 1

        j = l - 1
        if i != -1:
            # find j and swap
            while nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]

        # reverse i + 1, j
        lo = i + 1
        hi = l - 1
        mid = (lo + hi) // 2
        for k in range(lo, mid + 1):
            nums[k], nums[lo + hi - k] = nums[lo + hi - k], nums[k]

# x = [2,3,1]
# Solution().nextPermutation(x)
# print(x)
# assert x == [3,1,2]
