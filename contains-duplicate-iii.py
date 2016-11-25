class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if t < 0:
            return False

        # buckets. Each bucket only hold one value, bucket size is t + 1
        d = {}

        for i in range(len(nums)):
            num = nums[i]
            q = num // (t + 1)
            hasDuplicate = q in d or \
                    ((q - 1 in d) and (num - d[q - 1] <= t)) or \
                    ((q + 1 in d) and (d[q + 1] - num <= t))
            if hasDuplicate:
                return True

            d[q] = num

            if i + 1 > k:
                del d[nums[i - k] // (t + 1)]

        return False
