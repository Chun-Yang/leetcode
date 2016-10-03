class Solution(object):
    def findMedian(self, nums):
        nums_len = len(nums)
        if nums_len <= 0:
            raise Exception('nums_len should be positive')

        if nums_len % 2 == 0:
            return (nums[nums_len // 2 - 1] + nums[nums_len // 2]) / 2.0
        else:
            return nums[(nums_len) // 2]

    def getInner(self, nums, length):
        if length <= 3:
            return nums
        elif length % 2 == 0:
            return nums[length // 2 - 1 : length // 2 + 1]
        else:
            return nums[length // 2 - 1 : length // 2 + 2]

    def isCrossing(self, nums1, nums2):
        not_crossing = nums1[-1] < nums2[0] or nums1[0] > nums2[-1]
        return not not_crossing

    def shorten(self, nums, length, remove_larger):
        if remove_larger:
            return nums[:-length]
        else:
            return nums[length:]

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1_len = len(nums1)
        nums2_len = len(nums2)

        if nums1_len == 0:
            return self.findMedian(nums2)
        elif nums2_len == 0:
            return self.findMedian(nums1)
        elif nums1_len <= 3 and nums2_len <= 3:
            return self.findMedian(sorted(nums1 + nums2))
        else:
            nums1_inner = self.getInner(nums1, nums1_len)
            nums2_inner = self.getInner(nums2, nums2_len)
            if self.isCrossing(nums1_inner, nums2_inner):
                return self.findMedianSortedArrays(nums1_inner, nums2_inner)
            else:
                min_len = max(1, min(nums1_len, nums2_len) // 2)
                nums1_bigger = nums1_inner[0] > nums2_inner[0]
                return self.findMedianSortedArrays(
                        self.shorten(nums1, min_len, nums1_bigger),
                        self.shorten(nums2, min_len, not nums1_bigger)
                        )


# assert Solution().findMedianSortedArrays([1, 3], [2]) == 2
# assert Solution().findMedianSortedArrays([1, 2], [3, 4]) == 2.5
# assert Solution().findMedianSortedArrays([2], [1, 3, 4]) == 2.5
# assert Solution().findMedianSortedArrays([2, 3], [1, 4, 5]) == 3
# assert Solution().findMedianSortedArrays([3], [1, 2, 4, 5, 6]) == 3.5
# assert Solution().findMedianSortedArrays([1, 2, 6], [3, 4, 5]) == 3.5
