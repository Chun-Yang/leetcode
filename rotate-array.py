from fractions import gcd

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return nums

        l = len(nums)
        k = k % l
        visiting = gcd(l, k)
        for i in range(visiting):
            toId = (i + k) % l
            preserved = nums[i]
            while toId != i:
                preserved, nums[toId] = nums[toId], preserved
                toId = (toId + k) % l
            nums[i] = preserved
