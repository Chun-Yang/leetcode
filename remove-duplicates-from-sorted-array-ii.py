class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi, l = 2, 2, len(nums)

        if l <= 2:
            return l

        while hi < l:
            while True:
                if lo >= l:
                    break
                if (nums[lo] < nums[lo - 1]):
                    break
                if (nums[lo] == nums[lo - 1] and nums[lo] == nums[lo - 2]):
                    break
                lo += 1

            hi = max(lo, hi)
            while True:
                if hi >= l:
                    break
                if nums[hi] > nums[lo] and (nums[hi] > nums[lo - 1] or nums[hi] > nums[lo - 2]):
                    break
                hi += 1

            if hi < l:
                nums[lo], nums[hi] = nums[hi], nums[lo]
                lo += 1
                hi += 1

        return lo

# Solution().removeDuplicates([1, 2, 2])
