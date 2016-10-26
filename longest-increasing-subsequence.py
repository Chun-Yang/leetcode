from bisect import bisect_left

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        ends = [nums[0]]
        lengths = [1]

        def binarySearch(num):
            lo, hi = 0, len(ends)
            while (lo < hi):
                mid = (lo + hi) // 2
                if ends[mid] < num:
                    lo = mid + 1
                else:
                    hi = mid
            return lo

        for num in nums[1:]:
            if num < ends[0]:
                ends[0] = num
            elif num > ends[-1]:
                ends.append(num)
                lengths.append(lengths[-1] + 1)
            else:
                index = bisect_left(ends, num)
                ends[index] = num


        return lengths[-1]


# assert Solution().lengthOfLIS([3,5,6,2,5,4,19,5,6,7,12]) == 6
