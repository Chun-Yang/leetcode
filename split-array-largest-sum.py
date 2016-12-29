class Solution(object):
    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        # OBSERVER: the nums are all integers, so there are limited amount
        # of possible solutions to this problem
        # than we can try binary search
        # we can use greedy to determine if this number is a fit or not
        def isGroupable(target):
            groups, groupSum = 1, 0
            for num in nums:
                if groupSum + num <= target:
                    groupSum += num
                else:
                    groupSum = num
                    groups += 1
            return groups <= m

        lo, hi = max(nums), sum(nums)
        while lo < hi:
            mid = ( lo + hi ) // 2
            if isGroupable(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
