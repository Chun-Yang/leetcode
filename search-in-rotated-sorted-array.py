class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1

        # find the pivot (smallest)
        l = len(nums)
        def findShift(lo, hi):
            mid = (lo + hi) // 2
            if nums[mid] > nums[mid + 1]:
                return mid + 1
            elif nums[lo] < nums[mid]:
                return findShift(mid + 1, hi)
            else:
                return findShift(lo, mid)


        if l == 1 or nums[0] < nums[l-1]:
            shift = 0
        else:
            shift = findShift(0, l - 1)

        # use the pivot to construct the transform
        lo, hi = shift, shift + l - 1

        # binary search to find the pivot
        while lo <= hi:
            mid = (lo + hi) // 2
            curNum = nums[mid % l]
            if curNum < target:
                lo = mid + 1
            elif curNum > target:
                hi = mid - 1
            else:
                return mid % l

        return -1

# assert Solution().search([1], 0) == -1
# assert Solution().search([4,5,6,1,2,3], 3) == 5
# assert Solution().search([4,5,6,7,8,1,2,3], 3) == 7
# assert Solution().search([1,2,3,4,5,6], 3) == 2
# assert Solution().search([2,3,4,5,6,1], 3) == 1
