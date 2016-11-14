class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        if not nums:
            return 0

        prefixSums = [0] * len(nums)
        for i in range(len(nums)):
            prefixSums[i] = prefixSums[i-1] + nums[i]

        def merge(lo, hi):
            mid = (lo + hi) // 2

            if mid == lo:
                return 1 if lower <= prefixSums[lo] <= upper else 0

            countLeft = merge(lo, mid)
            countRight = merge(mid, hi)
            countCross = 0

            left = mid
            right = mid
            for i in range(lo, mid):
                while left < hi and prefixSums[left] - prefixSums[i] < lower:
                    left += 1
                while right < hi and prefixSums[right] - prefixSums[i] <= upper:
                    right += 1
                countCross += right - left

            prefixSums[lo:hi] = sorted(prefixSums[lo:hi])

            return countLeft + countRight + countCross

        return merge(0, len(prefixSums))

# assert Solution().countRangeSum([-2, 5, -1], -2, 2) == 3
# assert Solution().countRangeSum([], 0, 0) == 0
