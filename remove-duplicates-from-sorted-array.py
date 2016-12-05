class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)

        lo, hi = 0, l
        loPrev, hiPrev = - float('inf'), float('inf')

        while lo < hi:
            # print('=====')
            # print("lo, hi", lo, hi)
            # print("nums", nums)
            # print("loPrev, hiPrev", loPrev, hiPrev)
            if nums[lo] == loPrev:
                hi -= 1
                if nums[lo] == nums[hi]:
                    return lo
                while lo < hi and nums[hi] == hiPrev:
                    hi -= 1
                hiPrev = nums[hi]
                nums[lo], nums[hi] = nums[hi], nums[lo]
            elif nums[lo] == hiPrev:
                return lo
            else:
                loPrev = nums[lo]
            lo += 1

        # print('*****')
        # print("lo, hi", lo, hi)
        return hi

# x = [1,1,2,3]
# xExp = [1,2,3]
# ans = 3
# assert Solution().removeDuplicates(x) == ans
# assert set(x[0:ans]) == set(xExp)
